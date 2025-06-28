package com.example.csc325_firebase_webview_auth.view;

import com.example.csc325_firebase_webview_auth.model.CurrUser;
import com.example.csc325_firebase_webview_auth.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.ListUsersPage;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.csc325_firebase_webview_auth.view.App.scene;

public class LoginScreenController implements Initializable {

    @FXML
    protected Button loginButton;

    @FXML
    protected TextField usernameField;

    @FXML
    protected TextField passwordField;

    protected ArrayList<User> users = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);
            for (UserRecord user : page.iterateAll()) {
                User newUse = new User(user.getUid(), user.getDisplayName());
                users.add(newUse);
            }
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void login() throws FirebaseAuthException {
        for (int i = 0; users.size() > i; i++) {
            if (usernameField.getText().equals(users.get(i).getUsername())) {
                CurrUser.setCurrentUser(users.get(i));
                Stage stage = (Stage) usernameField.getScene().getWindow();
                try {
                    scene = new Scene(App.loadFXML("/files/LandingPage.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}
