package com.phantomstormx._036java;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class GameController {

    @FXML private StackPane tile1,  tile2,  tile3,  tile4;
    @FXML private StackPane tile5,  tile6,  tile7,  tile8;
    @FXML private StackPane tile9,  tile10, tile11, tile12;
    @FXML private StackPane tile13, tile14, tile15, tile16;
    @FXML private Button restart;
    @FXML private TextField score;
    @FXML private SplitMenuButton themeChange;

    private GameEngine engine;
    @FXML
    private StackPane[][] tiles;

    @FXML
    public void initialize() {
        engine = new GameEngine();// start the engine (spawns 2 tiles)

        // maps the 16 child StackPane(aka tiles) into a 2D array
        tiles = new StackPane[][] {
                { tile1,  tile2,  tile3,  tile4  },
                { tile5,  tile6,  tile7,  tile8  },
                { tile9,  tile10, tile11, tile12 },
                { tile13, tile14, tile15, tile16 }
        };
        render();
    }

    public void handleKeyPress(KeyEvent e) { // all key events, actual initializer is in main
        boolean moved = switch (e.getCode()) {
            case LEFT  -> engine.moveLeft();
            case RIGHT -> engine.moveRight();
            case UP    -> engine.moveUp();
            case DOWN  -> engine.moveDown();
            default    -> false;
        };
        if (moved) { // SPAWNS THE TILES YAYAYAAYYY
            engine.spawnTile();
            render();
        }
    }

    // Reads the engine's grid and redraws every tile
    private void render() {
        int[][] grid = engine.getGrid(); // gets grid logic from engine
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                StackPane tile = tiles[r][c];
                tile.getChildren().clear(); // Clears old tiles
                int value = grid[r][c]; // Gets current tile values
                if (value == 0) { // makes certain parts of the grid w/ out tiles the background color
                    tile.setStyle("-fx-background-color: #2E5090; -fx-background-radius: 6;");
                } else { // if parts of grid are not empty it will set the value and color of tile
                    Label lbl = new Label(String.valueOf(value));
                    lbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-background-radius: 6; ");
                    tile.getChildren().add(lbl);
                    tile.setStyle("-fx-background-radius: 6; -fx-background-color: " + tileColor(value) + ";" );
                }
            }
        }
    }
    private String tileColor(int val) {
        return switch (val) {
            case 3    -> "#dae8eeff";
            case 6    -> "#b6e3f5ff";
            case 12   -> "#70b2f1ff";
            case 24   -> "#5b94ecff";
            case 48   -> "#4276c7ff";
            case 96   -> "#275cacff";
            case 192  -> "#004cc5ff";
            case 384  -> "#0062ffff";
            case 768  -> "#0e78b8ff";
            case 1536 -> "#1889ceff";
            default   -> "#009fffff";
        };
    }

    @FXML
    private void restart() {

    }

    public void themeChange(ActionEvent actionEvent) {

    }
}