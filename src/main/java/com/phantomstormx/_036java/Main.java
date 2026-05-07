package com.phantomstormx._036java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);


    }

}
