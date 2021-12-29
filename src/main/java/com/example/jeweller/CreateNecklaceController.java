package com.example.jeweller;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class CreateNecklaceController {

    private List<Stone> stoneList = store.getStonesList();
    private List<Necklace> stoneNecklace = store.getNeckaceList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button calculateButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button menuButton;

    @FXML
    private Label necklaceList;

    @FXML
    private Label necklaceList1;

    @FXML
    private ChoiceBox<String> selector;

    @FXML
    private Button sortButton;

    @FXML
    private Slider value;

    @FXML
    private Label valueId;

    @FXML
    private Label weightId;

    @FXML
    void valueRelease(MouseEvent event) {
        valueId.setText(String.valueOf((int) value.getValue()));
    }

    @FXML
    void initialize() {
        stone();

        sortButton.setOnAction(event->{
            Collections.sort(stoneNecklace,Necklace.rankComparator);
            String necklace = "You add: ";
            for(int j=0;j<stoneNecklace.size();j++){
                necklace = necklace.concat("\n"+ stoneNecklace.get(j).getStone().getName() +
                        " x "+ stoneNecklace.get(j).getAmount());
            }
            necklaceList.setText(necklace);
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

        addButton.setOnAction(event ->{
           String stoneToAdd = selector.getValue();

           for (int i=0;i< stoneList.size();i++){
               if(stoneToAdd.equals(stoneList.get(i).getName())){
                   stoneNecklace.add(new Necklace(stoneList.get(i), (int) value.getValue())) ;
               }
               String necklace = "You add: ";
               for(int j=0;j<stoneNecklace.size();j++){
                   necklace = necklace.concat("\n"+ stoneNecklace.get(j).getStone().getName() +
                           " x "+ stoneNecklace.get(j).getAmount());
               }
               necklaceList.setText(necklace);
           }


        });

        calculateButton.setOnAction(event->{
            int preisTotal=0;
            int karatTotal=0;
            for(int i = 0; i < stoneNecklace.size(); i++){
                preisTotal+=stoneNecklace.get(i).getStone().getKarat()*stoneNecklace.get(i).getStone().getPrice()*stoneNecklace.get(i).getAmount();
                karatTotal+=stoneNecklace.get(i).getStone().getKarat()*stoneNecklace.get(i).getAmount();
            }
            weightId.setText("\nWeight - "+ karatTotal +" karat"+"\nPrice - "+ preisTotal+" $");
        });

        exitButton.setOnAction(event ->{
            System.exit(0);
        });

    }


    private void stone() {
        for(int i=0;i< stoneList.size();i++){
            selector.getItems().add(stoneList.get(i).getName());
        }

    }

}