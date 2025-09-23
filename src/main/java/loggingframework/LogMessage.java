package loggingframework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogMessage {

    private String Message;
    private LogLevel logLevel;
    private LocalDateTime timeStamp;

    public LogMessage(String message, LogLevel logLevel) {
        Message = message;
        this.logLevel = logLevel;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        this.timeStamp = LocalDateTime.parse(LocalDateTime.now().format(formatter));
    }

    public String getMessage() {
        return Message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public LogMessage setMessage(String message) {
        Message = message;
        return this;
    }

    public LogMessage setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public LogMessage setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public String toString(){
        return "[" + logLevel.name() + "] " + timeStamp.toString() + " "+ getMessage();
    }
}
