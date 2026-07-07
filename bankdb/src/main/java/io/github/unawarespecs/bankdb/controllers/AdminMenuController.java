package io.github.unawarespecs.bankdb.controllers;

import io.github.unawarespecs.bankapp.service.BankInterface;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.Setter;

import java.util.function.Consumer;

public class AdminMenuController
{
    @javafx.fxml.FXML
    private Button accountManagerBtn;
    @javafx.fxml.FXML
    private Button loanManagerBtn;
    @javafx.fxml.FXML
    private Button logoutBtn;

    private final BankInterface bankService;
    @Setter
    private Consumer<Stage> onLogoutRequested;
    @Setter
    private Consumer<Stage> onAccManagerRequested;
    @Setter
    private Consumer<Stage> onLoanManagerRequested;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public AdminMenuController(BankInterface bankService) {
        this.bankService = bankService;
    }

    @javafx.fxml.FXML
    public void onAccountManagerClick(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        if (onAccManagerRequested !=null){
            onAccManagerRequested.accept(stage);
        }
    }

    @javafx.fxml.FXML
    public void onLogoutButtonClick(ActionEvent actionEvent) {
        bankService.setCurrentlyLoggedInAdmin(null);

        showInformation();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        if (onLogoutRequested !=null){
            onLogoutRequested.accept(stage);
        }
    }

    @javafx.fxml.FXML
    public void onLoanManagerClick(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        if (onLoanManagerRequested !=null){
            onLoanManagerRequested.accept(stage);
        }
    }

    private void showInformation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Logged Out");
        alert.setHeaderText(null);
        alert.setContentText("You have successfully logged out of your session.");
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