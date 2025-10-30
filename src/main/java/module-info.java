module com.example.localdemoenkoin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.localdemoenkoin to javafx.fxml;
    exports com.example.localdemoenkoin;
}