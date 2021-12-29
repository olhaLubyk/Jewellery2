package com.example.jeweller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewStoneController {

    private List<Stone> stoneList = store.getStonesList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private Button findButton;

    @FXML
    private Button findTransButton;

    @FXML
    private TextField maxId;

    @FXML
    private Button menuButton;

    @FXML
    private TextField minId;

    @FXML
    private TextField nameId;

    @FXML
    private Label stoneByName;

    @FXML
    private Label transText;

    @FXML
    void initialize() {

        exitButton.setOnAction(event ->{
            System.exit(0);
        });

        findButton.setOnAction(event ->{
            String name = nameId.getText();
            for (int i = 0; i < stoneList.size(); i++) {
                if (name.equals(stoneList.get(i).getName()) ) {
                    stoneByName.setText( stoneList.get(i).getName()+"\n"+
                                    stoneList.get(i).getDescripion() +  "\n" +
                               "Transparency parameter - "    + stoneList.get(i).getTransPar()+
                          "\nValue of karat -" + stoneList.get(i).getKarat()+
                          "\nRank - "+  stoneList.get(i).getRank()+
                          "\nPrice - "+  stoneList.get(i).getPrice()+ "$" +
                           "\n"+ stoneList.get(i).getStoneValue()
                            );
                }

                }

        });

        findTransButton.setOnAction(event->{
            int start = Integer.parseInt(maxId.getText());
            int end = Integer.parseInt(minId.getText());
            String necklace = "Stones with " + start+ " >= x <=" +end;
            for (int i = 0; i < stoneList.size(); i++) {
                if (end <= stoneList.get(i).getTransPar() && start >= stoneList.get(i).getTransPar() ) {
                    necklace = necklace.concat("\n"+ stoneList.get(i).getName() +
                            " - "+ stoneList.get(i).getTransPar());

                    transText.setText(necklace);
                }

            }

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

    }

}
