<h1 align="center">Welcome to 3072! 👋</h1>

<p align="center">A Java GUI 3072 game built with javaFX, focused on clear structure, and an easy-to-use interface.

## How to play
- use your arrow keys(or WASD) to move blocks up, down, left and right
  - Once you move a your arrow key, all the blocks in the certain column or row will move. 
- merge tiles with their corresponding number until you get 3056(ex: 3 with 3 and 18 with 18)

## Features

Current and planned features may include:
total score, and best/high score
theme change button
exit button(YW @rgeorge-coach >:þ)
instructions page
new game/reset game button
undo button
actual game(wwoooow really)

## How It Works

The application is organized around a simple flow:

1. The user interacts with buttons in the GUI.
2. Button clicks trigger actions through event listeners.
3. The controller passes input to the engine/logic layer.
4. The engine evaluates the calculation or performs the requested operation.
5. The view updates to show the result or current state.

This keeps the UI, logic, and interaction handling separate and easier to maintain.

## How to Run

1. Open the project by cloneing the repo in IntelliJ IDEA.
2. Make sure the project SDK is set to Java 25.
3. Run the launcher class from the IDE.

If you are running from a compiled output folder, make sure the application is launched from the correct main entry point.

## Class Structure

The project is split into multiple classes to keep responsibilities organized.

### Main
- hooks up everything from the controller and fxml
- sends that information to the launcher


### Launcher
- Launches all of the classes, actually runs the game


### GameController
- all of the arrow key work, and animation and tile color is here
- engine is hooked up to this


### GameEngine
- all of the tile spawn, slide and merge, and arrow key functions are here
- where controller gets its information


### Game-View
- fxml that has the actual GUI for the game


## User Interface

The GUI is built using JavaFX and uses layout management rather than absolute positioning.  
This helps keep the interface organized and easier to resize or maintain.

## Challenges/Bugs
- Animation
  - we tried to use CSS for it but then ran into a problem because CSS animations such as cannot function well with FXML in animation and transition.
    - CSS is more used for colors and images, we did the colors in the FXML scene builder.
  - had to research some about how to do it manually, and figured it out.
  - we got the the spawn animations to work fine but when we did the merge it began to bug out by randomly animating an empty part of the grid.
- Score and high score
  - It was difficult to find out where to put the score code, since we did it last.
- Play again
  - Also hard to implement it into the code because we did it last, and when we had to push this code it disappeared, so we had to fix/redo that.
- Math
  - We had to figure out what the 3 factors were, and we thought that it ended with 3036 at first(it wasn't), then 3056(it wasn't), and we finally played the game to find out that it was 3072.     


## Credentials 
- https://hoangsonww.github.io/Game-2048-JavaFX/
- https://projectgurukul.org/java-2048-game/
- https://www.instructables.com/Program-Your-Own-2048-Game-WJava/
- Used replit AI for a lot of debugging in the engine and partially in the controller parts of this game
- [@DaNoob8157](https://github.com/DaNoob1857) for README layout, thanks :)
- [@ElliottAndCoachGeorge](https://github.com/ElliottAndCoachGeorge) for GUI help, thank you!
