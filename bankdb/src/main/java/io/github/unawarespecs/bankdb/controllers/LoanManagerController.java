package io.github.unawarespecs.bankdb.controllers;

import io.github.unawarespecs.bankapp.entity.LoanData;
import io.github.unawarespecs.bankapp.model.User;
import io.github.unawarespecs.bankapp.service.BankInterface;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class LoanManagerController
{
    @javafx.fxml.FXML
    private TextField loanDurationField;
    @javafx.fxml.FXML
    private TextField loanMaxLimitField;
    @javafx.fxml.FXML
    private TableColumn<LoanData, String> colLoanAccountName;
    @javafx.fxml.FXML
    private TableView<LoanData> loanAccountsTable;
    @javafx.fxml.FXML
    private TextField searchLoanField;
    @javafx.fxml.FXML
    private Button searchLoanBtn;
    @javafx.fxml.FXML
    private TableColumn<LoanData, Integer> colLoanTerm;
    @javafx.fxml.FXML
    private TableColumn<LoanData, Double> colLoanAmount;
    @javafx.fxml.FXML
    private Button savePlanBtn;
    @javafx.fxml.FXML
    private TableColumn<LoanData, Integer> colLoanAccountId;
    @javafx.fxml.FXML
    private Button backBtn;
    @javafx.fxml.FXML
    private TextField loanInterestField;
    @javafx.fxml.FXML
    private TableColumn<LoanData, Double> colLoanRate;

    private final BankInterface bankService;
    private Consumer<Stage> onBackRequested;

    private javafx.collections.ObservableList<LoanData> masterData = javafx.collections.FXCollections.observableArrayList();

    public void setOnBackRequested(Consumer<Stage> onBackRequested) {
        this.onBackRequested = onBackRequested;
    }

    @javafx.fxml.FXML
    public void initialize() {
        colLoanAccountId.setCellValueFactory(new PropertyValueFactory<>("userID"));
        colLoanAmount.setCellValueFactory(new PropertyValueFactory<>("moneyLeftToRepay"));
        colLoanRate.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
        colLoanTerm.setCellValueFactory(new PropertyValueFactory<>("duration"));

        colLoanAccountName.setCellValueFactory(new PropertyValueFactory<>("userID"));

        colLoanAmount.setCellFactory(tc -> new TableCell<>() {

        });

    }

    public LoanManagerController(BankInterface bankService) {
        this.bankService = bankService;
    }

    @javafx.fxml.FXML
    public void onBackClick(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        if (onBackRequested !=null){
            onBackRequested.accept(stage);
        }
    }

    @javafx.fxml.FXML
    public void onSavePlanClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onSearchLoanClick(ActionEvent actionEvent) {

    }

    private void showInformation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
