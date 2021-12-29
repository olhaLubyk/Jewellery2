package com.example.jeweller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button createNecklace;

    @FXML
    private Button createStone;

    @FXML
    private Button findStone;

    @FXML
    private Button exit;

    @FXML
    private Label menu;
    @FXML
    void initialize(MouseEvent event) {

    }

    @FXML
    void initialize() {

        menu.setOnMouseClicked(event ->{
            Shake menuAnim = new Shake(menu);
            menuAnim.playAnim();
        });

        createStone.setOnAction(event ->{
            createStone.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("stoneCreator.fxml"));

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
        createNecklace.setOnAction(event ->{
            createNecklace.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("createNecklace.fxml"));

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
        findStone.setOnAction(event ->{
            findStone.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("viewStone.fxml"));

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
        exit.setOnAction(event ->{
            System.exit(0);
        });

}
}


