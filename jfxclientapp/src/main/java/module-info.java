module jfxclientapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires bankdata;
    requires org.slf4j;

    opens io.github.unawarespecs.bankapp to javafx.fxml;
    exports io.github.unawarespecs.bankapp;
    exports io.github.unawarespecs.bankapp.jfx.controllers;
    opens io.github.unawarespecs.bankapp.jfx.controllers to javafx.fxml;
}