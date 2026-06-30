package io.github.unawarespecs.bankapp.jfx.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.setUserAgentStylesheet(
                Objects.requireNonNull(
                        getClass().getResource("/assets/css/fluent-override.css")
                ).toExternalForm()
        );
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
}
