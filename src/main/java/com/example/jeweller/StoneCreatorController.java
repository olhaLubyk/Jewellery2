package com.example.jeweller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class StoneCreatorController {

    @FXML
    private Slider Tra;

    @FXML
    private Button createButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label karatText;

    @FXML
    private Slider karatValue;

    @FXML
    private Label priceText;

    @FXML
    private Slider priceValue;

    @FXML
    private ToggleGroup rank;

    @FXML
    private RadioButton rank1;

    @FXML
    private RadioButton rank2;

    @FXML
    private RadioButton rank3;

    @FXML
    private RadioButton rank4;

    @FXML
    private ToggleGroup stone;

    @FXML
    private TextField stoneDescriptionField;

    @FXML
    private TextField stoneNameField;

    @FXML
    private RadioButton stoneSeprec;

    @FXML
    private RadioButton stovePrec;

    @FXML
    private Label transText;

    @FXML
    private Label transparencyParameter;

    @FXML
    private  Button menuButton;

    @FXML
    void initialize() {
        createButton.setOnAction(event ->{
            createStone();
        });

        menuButton.setOnAction(event ->{
            menuButton.getScene().getWindow().hide();
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
        });

        exitButton.setOnAction(event ->{
            System.exit(0);
        });

    }

    @FXML
    void karatRelease(MouseEvent event) {
        karatText.setText(String.valueOf((int) karatValue.getValue()));
    }

    @FXML
    void priceRelease(MouseEvent event) {
        priceText.setText(String.valueOf((int)priceValue.getValue()));
    }

    @FXML
    void transRelease(MouseEvent event) {transText.setText(String.valueOf((int)Tra.getValue()));}



    private void createStone() {
        DateBaseHandler dbHandler = new DateBaseHandler();
        List<Stone> stoneList = store.getStonesList();
        String stoneName = stoneNameField.getText();
        String stoneDiscription = stoneDescriptionField.getText();
        String stoneValue;
        int rank=0;
        if(stovePrec.isSelected())
            stoneValue ="Precious Stone";
        else
            stoneValue ="Semiprecious Stone";

        if(rank1.isSelected()) {
            rank=1;
        }
        if(rank2.isSelected()) {
            rank=2;
        }
        if(rank3.isSelected()) {
            rank=3;
        }
        if(rank4.isSelected()) {
            rank=4;
        }
        int karat = (int)karatValue.getValue();
        int transPar = (int)Tra.getValue();
        int price = (int)priceValue.getValue();

        Stone stone = new Stone(stoneName,stoneDiscription,karat,transPar,price,rank,stoneValue);
        stoneList.add(stone);
        dbHandler.addStone(stone);

    }

}