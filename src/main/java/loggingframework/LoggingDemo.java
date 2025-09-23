package loggingframework;

import loggingframework.appendstrategy.FileLogAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {

    private  static final Logging logger = Logging.getInstance();

    public static void main(String[] args) {
        logger.info("Hello world..");
        logger.debug("this is for debug the db transaction");
        logger.info("this is a good way to right log");
        logger.error("this is a error message");

        logger.info("this is a good way to right log");
        logger.setAppendType(new FileLogAppender("C:\\Users\\himan\\IdeaProjects\\Design-Pattern\\src\\main\\java\\loggingframework\\log_file.txt"));

        logger.error("Printing logs in file now");
        logger.info("this is info about loggingFramework");
        logger.warning("this is warning about memory threshold");
    }
}
