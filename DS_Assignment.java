import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.text.AbstractDocument.DefaultDocumentEvent;

public class DS_Assignment {

    // instance variable
    private JFrame frame;
    private JTextArea textArea;
    private JButton undoButton;
    private JButton redoButton;
    private JComboBox<String> fontComboBox;
    private JSpinner fontSizeSpinner;
    private JButton applyFontButton;
    private JButton applyFontSizeButton;
    private UndoManager undoManager;
    private Stack<DefaultDocumentEvent> undoStack;
    private Stack<DefaultDocumentEvent> redoStack;
    private JButton newButton;

    public DS_Assignment() {
        frame = new JFrame("Text Editor with Undo and Redo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea(20, 40);
        textArea.setLineWrap(true);// wrap the line of code

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();

        undoButton = new JButton("Undo");
        undoButton.addActionListener(new UndoAction());
        redoButton = new JButton("Redo");
        redoButton.addActionListener(new RedoAction());

        // Swing component that provides a drop-down list of items
        fontComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        // Java's Abstract Window Toolkit (AWT)
        // getAvailableFontFamilyNames() is a method provided by the GraphicsEnvironment
        // class. It returns an array of strings
        // that represents the names of all available font families on the local system

        // Other Way
        // String[] predFonts = {"Arial", "Times New Roman", "Courier New", "Verdana",
        // "Tahoma"};
        // fontComboBox = new JComboBox<>(predFonts);

        fontSizeSpinner = new JSpinner(new SpinnerNumberModel(12, 6, 72, 2));

        applyFontButton = new JButton("Apply Font");
        applyFontButton.addActionListener(new ApplyFontAction());

        applyFontSizeButton = new JButton("Change Font Size");
        applyFontSizeButton.addActionListener(new ApplyFontSizeAction());
        newButton = new JButton("New"); // New button to reset the content
        newButton.addActionListener(new NewAction());

        // Add to add the button on the Window Screen
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);
        buttonPanel.add(fontComboBox);
        buttonPanel.add(applyFontButton);
        buttonPanel.add(fontSizeSpinner);
        buttonPanel.add(applyFontSizeButton);
        buttonPanel.add(newButton); // Add the New button
        frame.add(buttonPanel, BorderLayout.SOUTH);

        undoManager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(undoManager);

        undoStack = new Stack<>();
        redoStack = new Stack<>();

        frame.pack();
        frame.setVisible(true);
    }

    // performs the undo Action
    private class UndoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (undoStack.isEmpty() && undoManager.canUndo()) {
                undoManager.undo();
            } else if (!undoStack.isEmpty()) {
                DefaultDocumentEvent event = undoStack.pop();
                redoStack.push(event);
                event.undo();
            }
        }
    }

    // perform the redo task
    private class RedoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!redoStack.isEmpty()) {
                DefaultDocumentEvent event = redoStack.pop();
                undoStack.push(event);
                event.redo();
            } else if (undoManager.canRedo()) {
                undoManager.redo();
            }
        }
    }

    // Apply the fontdesign
    private class ApplyFontAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedFont = (String) fontComboBox.getSelectedItem();
            Font currentFont = textArea.getFont();
            Font newFont = new Font(selectedFont, currentFont.getStyle(), currentFont.getSize());
            textArea.setFont(newFont);
        }
    }

    // new
    private class NewAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText(""); // Clear the text in JTextArea
            undoManager.discardAllEdits(); // Clear the undo/redo history
        }
    }

    // Apply fonsize
    private class ApplyFontSizeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int fontSize = (int) fontSizeSpinner.getValue(); // Get the selected font size from the JSpinner
            Font currentFont = textArea.getFont(); // Get the current font of the JTextArea
            Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), fontSize);
            // Create a new Font with the same font name, style, and the create the new font
            // size in the fontsize
            textArea.setFont(newFont); /// Set the JTextArea's font to the new font
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DS_Assignment());
    }
}