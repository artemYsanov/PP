module com.example.practic3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practic3 to javafx.fxml;
    exports com.example.practic3;
}