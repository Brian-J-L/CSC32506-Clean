package com.example.csc325_firebase_webview_auth.view;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.csc325_firebase_webview_auth.view.App.scene;

public class RegisterScreenController {

    @FXML
    protected TextField usernameField;

    @FXML
    protected TextField emailField;

    @FXML
    protected TextField passwordField;

    @FXML
    protected TextField phoneNumberField;

    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail("user@example.com")
                .setEmailVerified(false)
                .setPassword("secretPassword")
                .setPhoneNumber("+11234567890")
                .setDisplayName("John Doe")
                .setDisabled(false);

        try {
            UserRecord userRecord = App.fauth.createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getUid());
            return true;
        } catch (FirebaseAuthException ex) {
            return false;
        }
    }

    @FXML
    protected void register() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(emailField.getText())
                .setEmailVerified(false)
                .setPassword(passwordField.getText())
                .setPhoneNumber(phoneNumberField.getText())
                .setDisplayName(usernameField.getText())
                .setDisabled(false);

        try {
            UserRecord userRecord = App.fauth.createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getUid());

            Stage stage = (Stage) usernameField.getScene().getWindow();
            scene = new Scene(App.loadFXML("/files/LoginPage.fxml"));
            stage.setScene(scene);
            stage.show();

        } catch (FirebaseAuthException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

