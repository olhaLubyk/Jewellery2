package com.example.jeweller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    private List<Stone> stoneList = store.createArrayList();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Jeweller!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {launch();}
}