package org.designPattern.CommandPattern;

public class RemoveTextCommand implements Command{

    private TextEditor textEditor;
    private String removedText;
    private int count;

    public RemoveTextCommand(TextEditor textEditor, int count){
        this.textEditor = textEditor;
        this.count = count;
    }
    @Override
    public void execute() {
        removedText = textEditor.getText().substring(textEditor.getText().length() - count);
       textEditor.removeText(count);
    }

    @Override
    public void undo() {
       textEditor.addText(removedText);
    }
}
