package loggingframework.appendstrategy;

import loggingframework.LogMessage;

public class ConsoleLogAppender implements AppenderStrategy{
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage.toString());
    }
}
