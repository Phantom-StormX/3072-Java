<h1 align="center">Welcome to 3036! 👋</h1>

A Java GUI 3036 game built with javaFX, focused on clear structure, and an easy-to-use interface.

## Purpose

The purpose of this project is to create a desktop calculator that demonstrates:
- JavaFX GUI development
- Event handling with `ActionListener`
- Object-oriented design
- Separation of presentation, control, and logic

## Features

Current and planned features may include:


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


### Launcher


### GameController


### GameEngine


### Game-View


## User Interface

The GUI is built using JavaFX and uses layout management rather than absolute positioning.  
This helps keep the interface organized and easier to resize or maintain.
