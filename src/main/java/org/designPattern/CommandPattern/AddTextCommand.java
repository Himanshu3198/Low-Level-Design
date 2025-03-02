package org.designPattern.CommandPattern;

public class AddTextCommand implements Command {

    private  TextEditor textEditor;
    private  String text;

    public AddTextCommand(TextEditor textEditor, String text){
        this.textEditor = textEditor;
        this.text = text;
    }


    @Override
    public void execute() {
        textEditor.addText(text);
    }

    @Override
    public void undo() {
       textEditor.removeText(text.length());
    }
}
