module org.example.javalabfx2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javalabfx2 to javafx.fxml;
    exports org.example.javalabfx2;
}