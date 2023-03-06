module com.example.numberconversion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.numberconversion to javafx.fxml;
    exports com.example.numberconversion;
}