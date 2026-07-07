package io.github.unawarespecs.bankdb.controllers;

import io.github.unawarespecs.bankapp.model.Customer;
import io.github.unawarespecs.bankapp.model.User;
import io.github.unawarespecs.bankapp.service.BankInterface;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class AccountManagerController
{
    @javafx.fxml.FXML
    private ComboBox createRoleBox;
    @javafx.fxml.FXML
    private TableColumn<User, String> colName;
    @javafx.fxml.FXML
    private TextField createNameField;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TextField editNameField;
    @javafx.fxml.FXML
    private Button searchBtn;
    @javafx.fxml.FXML
    private Button saveDetailsBtn;
    @javafx.fxml.FXML
    private TableView<User> accountTable;
    @javafx.fxml.FXML
    private TableColumn<User, Double> colBalance;
    @javafx.fxml.FXML
    private TextField editBalanceField;
    @javafx.fxml.FXML
    private Button deleteBtn;
    @javafx.fxml.FXML
    private TextField editPasswordField;
    @javafx.fxml.FXML
    private TextField editPinField;
    @javafx.fxml.FXML
    private TextField createPasswordField;
    @javafx.fxml.FXML
    private Button backBtn;
    @javafx.fxml.FXML
    private Button freezeBtn;
    @javafx.fxml.FXML
    private TableColumn<User, String> colId;
    @javafx.fxml.FXML
    private TableColumn<User, String> colRole;
    @javafx.fxml.FXML
    private TableColumn<User, String> colStatus;

    private final BankInterface bankService;
    private Consumer<Stage> onBackRequested;

    @javafx.fxml.FXML
    public void initialize() throws Exception {
        User[] users = bankService.getAllUsers();

        colId.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        colName.setCellValueFactory(new PropertyValueFactory<>("username"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colBalance.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            if (user instanceof Customer) {
                return new SimpleObjectProperty<>(((Customer) user).getBalance());
            }
            return new SimpleObjectProperty<>(0.0); // Admins don't have balance
        });

        colStatus.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            if (user instanceof Customer) {
                boolean isFrozen = ((Customer) user).isAccountFrozen();
                return new SimpleStringProperty(isFrozen ? "Frozen" : "Active");
            }
            return new SimpleStringProperty("Active"); // Admins cannot be frozen
        });

        createRoleBox.setItems(FXCollections.observableArrayList("USER", "ADMIN"));

        if (users != null) {
            accountTable.setItems(FXCollections.observableArrayList(users));
        }
    }

    public AccountManagerController(BankInterface bankService) {
        this.bankService = bankService;
    }

    public void setOnBackRequested(Consumer<Stage> onBackRequested) {
        this.onBackRequested = onBackRequested;
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
    public void onSaveDetailsClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onDeleteClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onSearchClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onFreezeClick(ActionEvent actionEvent) {
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