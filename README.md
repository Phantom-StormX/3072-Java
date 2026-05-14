<h1 align="center">Welcome to 3072! 👋</h1>

A Java GUI 3072 game built with javaFX, focused on clear structure, and an easy-to-use interface.

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

1. Open the project in IntelliJ IDEA.
2. Make sure the project SDK is set to Java 25.
3. Run the main application class from the IDE.

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

## Credentials 
- https://hoangsonww.github.io/Game-2048-JavaFX/
- https://projectgurukul.org/java-2048-game/
- https://www.instructables.com/Program-Your-Own-2048-Game-WJava/
- Used replit AI for a lot of debugging in the engine and partially in the controller parts of this game
- @DaNoob8157 for README layout, thanks :)
- @ElliottAndCoachGeorge for GUI help, thank you!
