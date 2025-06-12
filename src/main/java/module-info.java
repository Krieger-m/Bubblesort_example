module com.krieger.aufgabetageskurs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.krieger.aufgabetageskurs to javafx.fxml;
    exports com.krieger.aufgabetageskurs;
    exports com.krieger.aufgabetageskurs.ctrl;
    opens com.krieger.aufgabetageskurs.ctrl to javafx.fxml;
    exports com.krieger.aufgabetageskurs.data;
    opens com.krieger.aufgabetageskurs.data to javafx.fxml;
}