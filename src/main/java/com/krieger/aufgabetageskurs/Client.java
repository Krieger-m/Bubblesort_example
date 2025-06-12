package com.krieger.aufgabetageskurs;

import com.krieger.aufgabetageskurs.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        new View().startView();

    }

    public static void main(String[] args) {
        launch();
    }
}