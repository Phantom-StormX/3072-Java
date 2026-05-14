package com.phantomstormx._036java;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

public class GameController {

    // initializes objects from scene builder to controller
    @FXML private StackPane tile1,  tile2,  tile3,  tile4;
    @FXML private StackPane tile5,  tile6,  tile7,  tile8;
    @FXML private StackPane tile9,  tile10, tile11, tile12;
    @FXML private StackPane tile13, tile14, tile15, tile16;
    @FXML private Button playAgain;
    @FXML private TextField score;
    private GameEngine engine;
    @FXML
    private StackPane[][] tiles;

    @FXML
    public void initialize() {
        engine = new GameEngine(); // starts the engine (spawns 2 tiles)

        tiles = new StackPane[][] { // maps the 16 child StackPane(aka tiles) into a 2D array
                { tile1,  tile2,  tile3,  tile4  },
                { tile5,  tile6,  tile7,  tile8  },
                { tile9,  tile10, tile11, tile12 },
                { tile13, tile14, tile15, tile16 }
        };

        /*

        This ensures that the key listener is added only after tile1 spawns which handles keyboard events in JavaFX,
        stops the event from reaching any further nodes or handlers

        (::) acts as a listener, provides a concise way to refer to
        a method or constructor without executing it. Primarily used as shorthand for lambda expressions.
        For example, instead of writing s -> System.out.println(s), you can simply write System.out::println
                                            |||||||||||||||
                                            ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
         */

        tile1.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) { // :: acts as a listener
                newScene.addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPress); // intercepts events during the early "capture" phase of the event dispatch chain
            }
        });
        render(); // updates display and graphics
    }

    public void handleKeyPress(KeyEvent e) { // all key events, actual initializer is in main

        switch (e.getCode()) {
            case LEFT, RIGHT, UP, DOWN -> e.consume(); //stops it from triggering further actions
            default -> { return;
            }
        }

        boolean moved = switch (e.getCode()) { // yoinks the logic about movement from engine and initializes it
            case LEFT  -> engine.moveLeft();
            case RIGHT -> engine.moveRight();
            case UP    -> engine.moveUp();
            case DOWN  -> engine.moveDown();
            default    -> false;
        };
        if (moved) { // SPAWNS THE TILES YAYAYAAYYY
            e.consume();
            engine.spawnTile();
            render(); // updates display

            for (int[] cell : engine.getLastMerges()){
                TileMergeAnm(tiles[cell[0]][cell[1]]);
            }

            int r = engine.getLastRow(); //yoinks the last row and column tracker from engine
            int c = engine.getLastCol();

            if( r >= 0 && c >= 0 ) { // safety check to ensure that the rows and columns indices(index) are non-negative(aka clear)
                SpawnTileAnm(tiles[r][c]);
            }
        }
    }

    // Reads the engine's grid and redraws every tile depending on the number it is at and if it merged or not
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
    private String tileColor(int val) { // colors and stuff for each tile
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
    private void playAgain() {

    }

    private void SpawnTileAnm(StackPane tile) {
        // sets the initial tile coord size to 0
        tile.setScaleX(0);
        tile.setScaleY(0);
        //changes the amount of time it takes for the transition to happen
        ScaleTransition inwardPop = new ScaleTransition(Duration.millis(200), tile);
        // original tile coord size(empty)
        inwardPop.setFromX(0);
        inwardPop.setFromY(0);
        // final tile coord size
        inwardPop.setToX(1.0);
        inwardPop.setToY(1.0);
        inwardPop.play();

    }

    private void TileMergeAnm(StackPane tile) {
        ScaleTransition pop = new ScaleTransition(Duration.millis(200), tile);
        pop.setFromX(1.0);
        pop.setFromY(1.0);
        pop.setToX(1.2); // makes newly merged tile larger
        pop.setToY(1.2);
        pop.setAutoReverse(true); // Returns newly merged tile to original size
        pop.setCycleCount(2);
        pop.play();

    }

}