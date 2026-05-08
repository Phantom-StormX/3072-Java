package com.phantomstormx._036java;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class GameController {
    @FXML
    private StackPane tile1, tile2, tile3, tile4,
            tile5, tile6, tile7, tile8, tile9, tile10, tile11, tile12,
            tile13, tile14, tile15, tile16; //declares all the components in FXML
    @FXML
    private StackPane[][] grid; //declares pane in FXML

    private GameEngine engine; //declares engine

}
