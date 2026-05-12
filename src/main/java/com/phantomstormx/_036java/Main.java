package com.phantomstormx._036java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game-View.fxml"));
        Parent root = loader.load();
        GameController controller = loader.getController();  // get the controller FXML created
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(controller::handleKeyPress);   // arrow key functions
        stage.setScene(scene);
        stage.show();

    }

}
