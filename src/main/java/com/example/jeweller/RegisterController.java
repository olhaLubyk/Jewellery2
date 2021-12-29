package com.example.jeweller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField LogField;

    @FXML
    private TextField PasField;

    @FXML
    private CheckBox customerCheck;

    @FXML
    private TextField lastNameField;

    @FXML
    private CheckBox maleCheck;

    @FXML
    private TextField nameField;

    @FXML
    private Button resiterButton;

    @FXML
    void initialize() {

        resiterButton.setOnAction(event ->{
            signUpNewUser();
            resiterButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signIn.fxml"));

            try {
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent root =loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Jeweller!");
            stage.show();
             });

    }

    private void signUpNewUser() {
        DateBaseHandler dbHandler = new DateBaseHandler();

        String fistName = nameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String login = LogField.getText().trim();
        String password = PasField.getText().trim();
        String gender;
        String job;
        if(maleCheck.isSelected())
            gender ="Male";
        else
            gender ="Female";

        if(customerCheck.isSelected()){
            job ="Customer";
        }else{
            job ="Jeweller";
        }
        User user = new User(fistName, lastName, login, password,gender,job);
        dbHandler.signUpUser(user);

    }

}