package org.designPattern.CommandPattern;

public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void addText(String newText){
        text.append(newText);
    }
    public  void removeText(int count){
        if( count <= text.length()){
            text.delete(text.length()-count,text.length());
        }
    }

    public String getText(){
         return text.toString();
    }
}
