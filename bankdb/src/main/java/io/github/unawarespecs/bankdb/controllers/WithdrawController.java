package io.github.unawarespecs.bankdb.controllers;

import io.github.unawarespecs.bankapp.model.Customer;
import io.github.unawarespecs.bankapp.model.Transaction;
import io.github.unawarespecs.bankapp.service.BankInterface;
import io.github.unawarespecs.bankdb.utils.PINValidator;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WithdrawController {

    private final BankInterface bankService;

    @FXML
    private TextField withdrawAmountField;

    @FXML
    private Label withdrawStatusLabel;

    public WithdrawController(BankInterface bankService) {
        this.bankService = bankService;
    }

    @FXML
    private void handleWithdrawSubmit(ActionEvent event) {

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

    public void handleBackToDashboard(ActionEvent actionEvent) {
    }
}
