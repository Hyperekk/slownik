module com.example.slownik {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.slownik to javafx.fxml;
    exports com.example.slownik;
}