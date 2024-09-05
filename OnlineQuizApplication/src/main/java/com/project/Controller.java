package com.project;

import java.awt.Button;
import java.awt.TextField;

import com.project.service.AuthService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

public class Controller {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    private AuthService authService;

    public Controller() {
        this.authService = new AuthService();
    }

    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authService.login(username, password)) {
            // Proceed to quiz selection screen
            // Example: Load next scene
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    public void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        authService.register(username, password);
        showAlert("Registration Successful", "You can now log in.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}