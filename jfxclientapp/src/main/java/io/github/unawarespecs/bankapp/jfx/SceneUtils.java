package io.github.unawarespecs.bankapp.jfx;

import io.github.unawarespecs.bankapp.service.BankInterface;
import io.github.unawarespecs.bankdb.controllers.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SceneUtils {

    public static void changeStage(Stage stage, String fxml, String title, BankInterface bankService) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneUtils.class.getClassLoader().getResource(fxml.startsWith("/") ? fxml.substring(1) : fxml));

        // Pass bankService to constructors requiring it
        fxmlLoader.setControllerFactory(param -> {

            if (param == MenuController.class) {
                MenuController controller = new MenuController(bankService);
                controller.setOnLogoutRequested((currentStage) -> {
                    try {
                        SceneUtils.changeStage(currentStage, "/io/github/unawarespecs/bankapp/jfx/controllers/login.fxml", "Login", bankService);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                return controller;
            }
            // add controllers here
            try {
                return param.getConstructor(BankInterface.class).newInstance(bankService);
            } catch (NoSuchMethodException e) {
                try {
                    return param.getDeclaredConstructor().newInstance();
                } catch (Exception ex) {
                    throw new RuntimeException("Failed to instantiate controller: " + param.getName(), ex);
                }
            } catch (Exception e){
                throw new RuntimeException("Dependency injection failed for controller: " + param.getName(), e);
            }
        });

        Scene scene = new Scene(fxmlLoader.load());
        scene.setUserAgentStylesheet(
                Objects.requireNonNull(
                        SceneUtils.class.getResource("/assets/css/fluent-override.css")
                ).toExternalForm()
        );
        stage.setFullScreen(true);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void popUpStage(String fxml, String title, BankInterface bankService) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneUtils.class.getResource(fxml));

        fxmlLoader.setControllerFactory(param -> {
            try {
                return param.getConstructor(BankInterface.class).newInstance(bankService);
            } catch (Exception e) {
                try {
                    return param.getConstructor().newInstance();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Scene scene = new Scene(fxmlLoader.load());
        scene.setUserAgentStylesheet(
                Objects.requireNonNull(
                        SceneUtils.class.getResource("/assets/css/fluent-override.css")
                ).toExternalForm()
        );
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}