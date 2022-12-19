package com.example.practic3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox CheckBoxMenRegistration;

    @FXML
    private CheckBox CheckBoxRegistration;

    @FXML
    private Button EntranceRegistration1;

    @FXML
    private Button EntranceRegistration;

    @FXML
    private TextField LastNameRegistration;

    @FXML
    private TextField LoginRegistration;

    @FXML
    private TextField NameRegistration;

    @FXML
    private TextField PasswordRegistration;


    @FXML
    void initialize() {
        EntranceRegistration1.setOnMouseClicked(click -> {
            try {
                String line = (PasswordRegistration.getText());
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Artem\\IdeaProjects\\Practic3\\src\\main\\java\\com\\example\\practic3\\inputPassword.txt");
                byte[] buffer = line.getBytes();
                fileOutputStream.write(buffer);
                System.out.println("Сохранено");
            } catch (Exception e){
                System.out.println("Не удалось сохранить");
            }
        });

        EntranceRegistration1.setOnAction(event -> {
            try {
                String line = (LoginRegistration.getText());
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Artem\\IdeaProjects\\Practic3\\src\\main\\java\\com\\example\\practic3\\inputLogin.txt");
                byte[] buffer = line.getBytes();
                fileOutputStream.write(buffer);
                System.out.println("Сохранено");
            }catch (Exception e){
                System.out.println("Не удалось сохранить");
            }
        });

        EntranceRegistration.setOnAction(event -> {
            EntranceRegistration.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));

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
