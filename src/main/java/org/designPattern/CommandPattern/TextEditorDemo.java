package org.designPattern.CommandPattern;

public class TextEditorDemo {
    public static void main(String[] args) {


        TextEditor editor = new TextEditor();
        CommandManager manager = new CommandManager();
        manager.executeCommand(new AddTextCommand(editor, "Hello"));
        manager.executeCommand(new AddTextCommand(editor, "World"));

        System.out.println(editor.getText());
        manager.undoCommand();
        System.out.println(editor.getText());
        manager.redoCommand();
        System.out.println(editor.getText());
        manager.executeCommand(new RemoveTextCommand(editor, 5));
        System.out.println(editor.getText());
        manager.undoCommand();
        System.out.println(editor.getText());
        manager.redoCommand();
        System.out.println();
    }





}
