package com.example.slownik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HelloController {
    public TextArea txt2;
    public TextArea txt1;
    public Button btn1;
    public Button btn2;
    @FXML
    private Label welcomeText;

    Map<String, String> slownik = new HashMap<>();

    String nazwa;
    String wyjasnienie;
    @FXML

    public void Btn1_click(ActionEvent actionEvent)
    {
        nazwa = txt1.getText();
        wyjasnienie = txt2.getText();

        int i = 0;

        if(nazwa == null || wyjasnienie == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Zapisz nazwe i wyjaśnienie");
            alert.showAndWait();
        }



        if (slownik.containsValue(nazwa))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Zapis o takiej nazwie juz istnieje");
            alert.showAndWait();
        }
        else if (slownik.containsValue(wyjasnienie))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Zapis o takiej nazwie juz istnieje");
            alert.showAndWait();
        }
        else
        {
            slownik.put(nazwa, wyjasnienie);
        }


           

    }

    public void Btn2_click(ActionEvent actionEvent) throws IOException {
        Path path = Paths.get("C:/ZiomekczkiZiomy/slownik.txt");
        if (!Files.exists(path))
            Files.createFile(path);

        String tekstDoZapisania = slownik.toString();

        Files.write(path, tekstDoZapisania.getBytes());
    }
}