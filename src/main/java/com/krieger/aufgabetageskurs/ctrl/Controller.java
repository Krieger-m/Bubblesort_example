package com.krieger.aufgabetageskurs.ctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import com.krieger.aufgabetageskurs.view.View;

public class Controller {
    @FXML
    private TableColumn<String, Double> col_aktienkurs;

    @FXML
    private TableView<Double> table_view;

    public TableColumn getCol_aktienkurs() {
        return col_aktienkurs;
    }

    public void setCol_aktienkurs(TableColumn col_aktienkurs) {
        this.col_aktienkurs = col_aktienkurs;
    }

    public static void getContent() throws IOException {
        FXMLLoader loader = View.getLoader();
        Parent root = loader.load();
        Controller controller = loader.getController();
        TableColumn<String, Double> col = controller.getCol_aktienkurs();
        System.out.println(col.getText());
    }

}