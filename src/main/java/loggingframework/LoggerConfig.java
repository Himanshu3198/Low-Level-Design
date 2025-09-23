package loggingframework;

import loggingframework.appendstrategy.AppenderStrategy;
import loggingframework.appendstrategy.ConsoleLogAppender;

public class LoggerConfig {

     private String message;
     private LogLevel logLevel;
     private AppenderStrategy appenderStrategy;

     public LoggerConfig(){
         this.appenderStrategy = new ConsoleLogAppender();
     }


     public void setConfig(LogLevel logLevel, String message){
         this.logLevel = logLevel;
         this.message = message;
         appendLog();

     }

     public void appendLog(){
         appenderStrategy.append(new LogMessage(message,logLevel));
     }

     public void setAppenderStrategy(AppenderStrategy appenderStrategy){
         this.appenderStrategy = appenderStrategy;
     }

}
