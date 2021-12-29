package com.example.jeweller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;

import animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LogField;

    @FXML
    private TextField PasField;

    @FXML
    private Button exitButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button singButton;

    @FXML
    void initialize() {

    registerButton.setOnAction(event ->{
        registerButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("register.fxml"));
        try {
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
    Parent root =loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Jeweller!");
        stage.showAndWait();
    });

        singButton.setOnAction(event ->{
            String loginText = LogField.getText();
            String passwordText = PasField.getText();
            logUser(loginText,passwordText);
        });
    }

    private void logUser(String loginText, String passwordText) {
        DateBaseHandler dbHandler = new DateBaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        ResultSet result = dbHandler.getUser(user);

        int counter =0;
            try {
               while (result.next()) {counter++;}
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if(counter>=1){
            singButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("mainMenu.fxml"));

            try {
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent root =loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Jeweller!");
            stage.showAndWait();

        }else{
            Shake userLoginAnim = new Shake(LogField);
            Shake userPassAnim = new Shake(PasField);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();

        }
    }

}
