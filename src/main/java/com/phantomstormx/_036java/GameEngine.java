package com.phantomstormx._036java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* this is a test for the grid, coach g suggested we use an arraylist instead of a 2D int array
   if it does not work how we want it to, we can change it to a 2D int array.
    */

public class GameEngine {

    int[][] grid = new int[4][4]; // creates a grid with 4 rows and 4 columns
    Random rand = new Random(); // self explainable

    private int lastRow = -1, lastCol = -1;

    public int getLastRow() {
        return lastRow;
    }

    public int getLastCol() {
        return lastCol;
    }

    private final List<int[]> mergedCells = new ArrayList<>();

    public List<int[]> getLastMerges() {
        return mergedCells;
    }

    //spawns in 2 tiles @the beginning of the game
    public GameEngine() {
        spawnTile();
        spawnTile();
    }

    public void spawnTile() {

        List<int[]> emptyCells = new ArrayList<>(); // makes an arraylist for the empty grid tiles, an ArrayList that holds other ArrayLists B)


        // Find all empty grid tiles in the grid
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (grid[r][c] == 0) emptyCells.add(new int[]{r, c}); // returns a new array of numbers(ex:[1,10])
                // if the grid is empty, it will generate one tile
            }
        }

        /*
        (?) Takes two different things after a certain assignment,
         and lets it choose between a certain
        amount of objects, such as 3 and 6 in this case.
        it's like an if else statement
         */

        if (!emptyCells.isEmpty()) { // makes sure parts of the grid is empty
            int[] spot = emptyCells.get(rand.nextInt(emptyCells.size())); // selects a random coordinate in the grid to place tile
            grid[spot[0]][spot[1]] = (rand.nextDouble() < 0.9) ? 3 : 6; // places the tile of either 3(90% chance of generating) or 6(10% chance of generating)
            // tracks where tiles spawn
            lastRow = spot[0];
            lastCol = spot[1];
        }
    }

    private int[] slideAndMerge(int[] row, List<Integer> mergedAt) {
        int[] packed = new int[4];  // moves all non-zero numbers to the left, keeps it nice and organized
        boolean[] completedMerge = new boolean[4];
        int idx = 0; // makes an index for the row
        for (int v : row) if (v != 0) packed[idx++] = v;
        for (int i = 0; i < 3; i++) {
            if (packed[i] != 0 && packed[i] == packed[i + 1]) { // checks if a tile is empty or not then matches the tile next to it
                packed[i] *= 2; // doubles the value when merged
                packed[i + 1] = 0;
                completedMerge[i] = true;
                i++; // skips to the next index so that it does not accidentally double merge
            }
        }
        //filters out 0 and returns and array up to four characters
        int[] result = new int[4];
        idx = 0; // index for loop
        for (int i = 0; i < 4; i++) { // starts at 0, and goes through the packed information then goes through a loop from least number to greatest number
            if (packed[i] != 0) {
                result[idx] = packed[i];
                if (completedMerge[i]) {
                    mergedAt.add(idx); // carry merge flag into result position
                }
                idx++;
            }
        }
        return result;
    }

    //Controls the movements for the left arrow
    public boolean moveLeft() {
        boolean moved = false;
        mergedCells.clear();
        for (int r = 0; r < 4; r++) {
            List<Integer> mergedAt = new ArrayList<>();
            int[] merged = slideAndMerge(grid[r], mergedAt); // takes the array representing the row, returns a new array of the same size, and ensures values are combined once per move


            //identifies whether a movement or merge happened or not
            if (!Arrays.equals(grid[r], merged)) moved = true;
            grid[r] = merged;
            for (int c : mergedAt) {
                mergedCells.add(new int[]{r, c});
            }
        }
        return moved;
    }

    //Controls the movements for the right arrow key
    public boolean moveRight() {
        boolean moved = false;
        mergedCells.clear();
        for (int r = 0; r < 4; r++) {
            List<Integer> mergedAt = new ArrayList<>();
            int[] merged = reverse(slideAndMerge(reverse(grid[r]), mergedAt));
            //identifies whether a movement or merge happened or not
            if (!Arrays.equals(grid[r], merged)) moved = true;
            grid[r] = merged;
            for (int c : mergedAt) {
                mergedCells.add(new int[]{r, 3 - c}); // un-reverse column index
            }
        }
        return moved;
    }

    //Controls the movements for the up arrow key
    public boolean moveUp() {
        boolean moved = false;
        mergedCells.clear();
        for (int c = 0; c < 4; c++) {
            List<Integer> mergedAt = new ArrayList<>();
            int[] col = getCol(c);
            int[] merged = slideAndMerge(col, mergedAt);
            //identifies whether a movement or merge happened or not
            if (!Arrays.equals(col, merged)) moved = true;
            setCol(c, merged);
            for (int r : mergedAt) {
                mergedCells.add(new int[]{r, c});
            }
        }
        return moved;
    }

    //Controls the movements for the up arrow key
    public boolean moveDown() {
        boolean moved = false;
        mergedCells.clear();
        for (int c = 0; c < 4; c++) {
            List<Integer> mergedAt = new ArrayList<>();
            int[] col = getCol(c);
            int[] merged = reverse(slideAndMerge(reverse(col), mergedAt));
            //identifies whether a movement or merge happened or not
            if (!Arrays.equals(col, merged)) moved = true;
            setCol(c, merged);
            for (int r : mergedAt) {
                mergedCells.add(new int[]{3 - r, c}); // un-reverse row index
            }
        }
        return moved;
    }

    //creates and returns a new array in which is reversed from og input
    private int[] reverse(int[] a) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) r[i] = a[a.length - 1 - i];
        return r;
    }

    //Extracts a specific column from a 2D array and returns as a 1D array
    private int[] getCol(int c) { // creates a 4-element array, loops rows, & copies values
        int[] col = new int[4];
        for (int r = 0; r < 4; r++) col[r] = grid[r][c];
        return col;
    }

    //updates a specific column in a 2D array with values in provided array
    private void setCol(int c, int[] col) {
        for (int r = 0; r < 4; r++) grid[r][c] = col[r];
    }

    public int[][] getGrid() {
        return grid;
    }

}
