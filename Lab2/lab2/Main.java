package lab2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        try {
            logManager.readConfiguration(Main.class.getClassLoader().getResourceAsStream("log.properties"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Cannot get log configuration!");
            return;
        }


        Calculator calculator;
        String input_name;
        calculator = new Calculator();

        if (args.length > 1) {
            logger.log(Level.WARNING, "Error. To many args");
        } else if (args.length == 1) {
            logger.log(Level.INFO, "Open input file...");
            input_name = args[0];
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(input_name);
                calculator.ran_calc(fileInputStream);
            } catch (FileNotFoundException e) {
                logger.log(Level.WARNING, "Cannot open file!");
                throw new RuntimeException(e);
            }
        } else {
            calculator.ran_calc(System.in);
        }
        logger.log(Level.FINE, "End of the application work.");
    }
}