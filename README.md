Here's a README file for your Java Text Editor application with undo and redo functionalities. This README provides an overview of the application, its features, and instructions for setup and usage.

---

# Text Editor with Undo and Redo

## Overview

The Text Editor with Undo and Redo is a Java-based Swing application that provides a basic text editing interface. It includes features for undoing and redoing text changes, applying different fonts and font sizes, and creating a new blank document. This application is ideal for learning about Swing components, undo/redo functionalities, and font manipulation in Java.

## Features

- **Undo and Redo**: Allows users to undo and redo text changes using buttons.
- **Font Selection**: Provides a dropdown list to choose from available system fonts.
- **Font Size Adjustment**: Allows users to adjust the font size using a spinner control.
- **New Document**: Resets the text area and clears the undo/redo history.
- **Text Wrapping**: Automatically wraps lines in the text area.

## GUI Components

- **JTextArea**: The main text editing area where users can type and edit text.
- **JButton**: Buttons for undo, redo, applying fonts, changing font sizes, and creating a new document.
- **JComboBox**: Dropdown for selecting fonts.
- **JSpinner**: Spinner for selecting font size.
- **JScrollPane**: Scroll pane to add scroll bars to the text area.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed on your machine.

## Setup and Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/DS_Assignment.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd DS_Assignment
   ```

3. **Compile the Code**:
   ```bash
   javac DS_Assignment.java
   ```

4. **Run the Application**:
   ```bash
   java DS_Assignment
   ```

## Usage

1. **Text Editing**: Type and edit text in the main text area.
2. **Undo/Redo**: Use the "Undo" and "Redo" buttons to revert or reapply text changes.
3. **Font Selection**: Choose a font from the dropdown and click "Apply Font" to change the text area font.
4. **Font Size**: Use the spinner to select a font size and click "Change Font Size" to apply it.
5. **New Document**: Click "New" to clear the text area and reset the undo/redo history.

## How It Works

- **Undo/Redo**: Uses `UndoManager` and custom `Stack` to manage undo and redo operations. The custom undo and redo actions handle `DefaultDocumentEvent` objects to apply changes.
- **Font Application**: Changes the font of the text area based on user selection.
- **New Document**: Clears the text area and discards all edits in the undo manager.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

