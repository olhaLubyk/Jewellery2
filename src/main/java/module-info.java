module com.example.jeweller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.jeweller to javafx.fxml;
    exports com.example.jeweller;
}