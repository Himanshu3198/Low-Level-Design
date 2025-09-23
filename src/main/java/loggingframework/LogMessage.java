package loggingframework;

import java.time.LocalDateTime;

public class LogMessage {

    private String Message;
    private LogLevel logLevel;
    private LocalDateTime timeStamp;

    public LogMessage(String message, LogLevel logLevel, LocalDateTime timeStamp) {
        Message = message;
        this.logLevel = logLevel;
        this.timeStamp = timeStamp;
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
}
