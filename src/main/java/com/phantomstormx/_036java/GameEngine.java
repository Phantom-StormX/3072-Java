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

    public GameEngine() {
        spawnTile();
        spawnTile();
    }

    public void spawnTile() {

        List<int[]> emptyCells = new ArrayList<>(); // makes an arraylist for the empty grid tiles, an ArrayList that holds other ArrayLists B)

        // Find all empty grid tiles in the grid
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (grid[r][c] == 0) emptyCells.add(new int[]{r, c}); // if the tile is empty, it will generate one tile
            }
        }

        if (!emptyCells.isEmpty()) { // makes sure parts of the grid is empty
            int[] spot = emptyCells.get(rand.nextInt(emptyCells.size())); // selects a random coordinate in the grid to place tile
            grid[spot[0]][spot[1]] = (rand.nextDouble() < 0.9) ? 3 : 6; // places the tile of either 3(90% chance of generating) or 6(10% chance of generating)
        }
    }

    private int[] slideAndMerge(int[] row) {
        int[] packed = new int[4];  // moves all non-zero numbers to the left, keeps it nice and organized
        int idx = 0; // makes an index for the row
        for (int v : row) if (v != 0) packed[idx++] = v;
        for (int i = 0; i < 3; i++) {
            if (packed[i] != 0 && packed[i] == packed[i + 1]) { // checks if a tile is empty or not then matches the tile next to it
                packed[i] *= 2; // doubles the value when merged
                packed[i + 1] = 0;
                i++; // skips to the next index so that it does not accidentally double merge
            }
        }
        int[] result = new int[4];
        idx = 0;
        for (int v : packed) if (v != 0) result[idx++] = v;
        return result;
    }

    public boolean moveLeft()  {
        boolean moved = false;
        for (int r = 0; r < 4; r++) {
            int[] merged = slideAndMerge(grid[r]);
            if (!Arrays.equals(grid[r], merged)) moved = true;
            grid[r] = merged;
        }
        return moved;
    }
    public boolean moveRight() {
        boolean moved = false;
        for (int r = 0; r < 4; r++) {
            int[] merged = reverse(slideAndMerge(reverse(grid[r])));
            if (!Arrays.equals(grid[r], merged)) moved = true;
            grid[r] = merged;
        }
        return moved;
    }
    public boolean moveUp() {
        boolean moved = false;
        for (int c = 0; c < 4; c++) {
            int[] col = getCol(c);
            int[] merged = slideAndMerge(col);
            if (!Arrays.equals(col, merged)) moved = true;
            setCol(c, merged);
        }
        return moved;
    }
    public boolean moveDown() {
        boolean moved = false;
        for (int c = 0; c < 4; c++) {
            int[] col = getCol(c);
            int[] merged = reverse(slideAndMerge(reverse(col)));
            if (!Arrays.equals(col, merged)) moved = true;
            setCol(c, merged);
        }
        return moved;
    }
    private int[] reverse(int[] a) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) r[i] = a[a.length - 1 - i];
        return r;
    }
    private int[] getCol(int c) {
        int[] col = new int[4];
        for (int r = 0; r < 4; r++) col[r] = grid[r][c];
        return col;
    }
    private void setCol(int c, int[] col) {
        for (int r = 0; r < 4; r++) grid[r][c] = col[r];
    }

    // Compact non-zeros left, merge equal adjacent pairs, compact again

}
