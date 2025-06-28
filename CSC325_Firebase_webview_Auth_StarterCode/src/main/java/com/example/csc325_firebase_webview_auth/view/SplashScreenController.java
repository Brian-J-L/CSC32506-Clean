package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.csc325_firebase_webview_auth.view.App.scene;

public class SplashScreenController {

    @FXML
    protected Button registerButton;

    @FXML
    protected Button loginButton;

    @FXML
    protected void register() {
        Stage stage = (Stage) registerButton.getScene().getWindow();
        try {
            scene = new Scene(App.loadFXML("/files/RegisterPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void login() {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        try {
            scene = new Scene(App.loadFXML("/files/LoginPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();
    }
}
