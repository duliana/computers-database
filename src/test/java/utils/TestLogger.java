package utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class TestLogger {

    public static Logger logger = Logger.getLogger(TestLogger.class);

    private static TestLogger instance = null;

    protected TestLogger() {
        // Exists only to defeat instantiation.
    }

    public static TestLogger getInstance() {
        if(instance == null) {
            BasicConfigurator.configure();
            instance = new TestLogger();
        }
        return instance;
    }

    public void log(String message){
        logger.info(message);
    }
}
