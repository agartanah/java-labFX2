package org.example.javalabfx2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("canvas.fxml")));
        Scene scene = new Scene(root, 900, 600);

        // Подключаем CSS
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        stage.setTitle("Пример с FXML и CSS");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}