package com.phantomstormx._036java;

import java.util.ArrayList;

public class GameEngine {
    private final int GameSize = 4;
    private final int winningNum = 3036;
    private boolean GameOver;

    ArrayList<ArrayList<Integer>> Grid = new ArrayList<>(); // Declares an ArrayList that holds other ArrayLists B)

    /* this is a test for the grid, coach g suggested we use an arraylist instead of a 2D int array
    if it does not work how we want it to, we can change it to a 2D int array.
     */

   public GameEngine (int score){
       // creates 4 rows
       for (int r = 0; r < 4; r++) {
           ArrayList<Integer> row = new ArrayList<>(); // stores the rows in the arraylist

           // creates 4 columns
           for (int c = 0; c < 4; c++) {
               row.add(0); // adds the columns with the rows
           }
           Grid.add(row); // actually initializes the rows(columns are connected to rows)
       }

   }
}