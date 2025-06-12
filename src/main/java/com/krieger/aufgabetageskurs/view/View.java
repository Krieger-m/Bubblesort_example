package com.krieger.aufgabetageskurs.view;

import com.krieger.aufgabetageskurs.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View {

    private Stage stage;
    private Scene scene;
    private static  FXMLLoader loader;
    private static boolean isShowing = false;

    public void startView() throws IOException {
        this.stage = new Stage();
         loader= new FXMLLoader(Client.class.getResource("hello-view.fxml"));
         this.scene= new Scene(loader.load(), 320, 240);
        this.stage.setTitle("Hello!");
        this.stage.setScene(scene);
        this.stage.show();
        isShowing = true;
    }

    public static FXMLLoader getLoader() {
        return (loader != null)?loader:new FXMLLoader(Client.class.getResource("hello-view.fxml"));
    }
}
