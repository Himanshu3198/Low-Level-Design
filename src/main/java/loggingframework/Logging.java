package loggingframework;


import loggingframework.appendstrategy.AppenderStrategy;

public class Logging {

    private static volatile Logging instance;
    private final LoggerConfig loggerConfig;

    private Logging() {
        this.loggerConfig = new LoggerConfig();
    }

    public static Logging getInstance() {
        if (instance == null) {
            synchronized (Logging.class) {
                if (instance == null) {
                    instance = new Logging();
                }
            }
        }
        return instance;
    }

    public void info(String message){
        loggerConfig.setConfig(LogLevel.INFO,message);
    }
    public void error(String message){
        loggerConfig.setConfig(LogLevel.ERROR,message);
    }
    public void debug(String message){
        loggerConfig.setConfig(LogLevel.DEBUG,message);
    }
    public void warning(String message){
        loggerConfig.setConfig(LogLevel.WARNING,message);
    }
    public void fatal(String message){
        loggerConfig.setConfig(LogLevel.FATAL,message);
    }
    public void setAppendType(AppenderStrategy appenderStrategy){
        loggerConfig.setAppenderStrategy(appenderStrategy);
    }

}
