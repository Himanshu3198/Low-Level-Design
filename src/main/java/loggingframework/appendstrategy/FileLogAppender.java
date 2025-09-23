package loggingframework.appendstrategy;

import loggingframework.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogAppender implements AppenderStrategy{

    private final String filePath;

    public FileLogAppender(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void append(LogMessage logMessage) {

        try(FileWriter writer = new FileWriter(filePath,true)){
            writer.append(logMessage.toString()+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
