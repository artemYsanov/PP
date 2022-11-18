package com.example.practic3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EntranceAuthorization;

    @FXML
    private TextField LoginAuthorization;

    @FXML
    private TextField PasswordAuthorization;

    @FXML
    private Button RegistrationAuthorization;

    @FXML
    void initialize() {
        EntranceAuthorization.setOnAction(event -> {
            EntranceAuthorization.setText("Спасибо за регистрацию");
            System.out.println("Логин: " + LoginAuthorization.getText());
            System.out.println("Пароль: " + PasswordAuthorization.getText());
            EntranceAuthorization.getScene().getWindow().hide();

            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Artem\\IdeaProjects\\Practic3\\src\\main\\java\\com\\example\\practic3\\inputPassword.txt")))
            {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(PasswordAuthorization.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("home.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("password success");
                    } else {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("error.fxml"));
                        loader.load();
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    }
                }
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Artem\\IdeaProjects\\Practic3\\src\\main\\java\\com\\example\\practic3\\inputLogin.txt")))
            {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(LoginAuthorization.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("home.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("login success");
                    } else {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("error.fxml"));
                        loader.load();
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        RegistrationAuthorization.setOnAction(event -> {
            RegistrationAuthorization.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("registration.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

}
