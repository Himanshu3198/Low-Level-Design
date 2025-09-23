package loggingframework.appendstrategy;

import loggingframework.LogMessage;

public interface AppenderStrategy {
    void append(LogMessage logMessage);
}
