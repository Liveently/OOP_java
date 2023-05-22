package lab2;

import lab2.Commands.Command;
import lab2.Exceptions.CalculatorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    Context context = new Context();

    public Calculator(){}

    public void ranCalc(InputStream input){
        var bufferedReader = new BufferedReader(new InputStreamReader(input));

        String arguments;
        Command command;

        logger.log(Level.INFO, "Start process...");
        while (true){
            try{
                if((arguments = bufferedReader.readLine()) == null || arguments.equals("")){
                    break;
                }else{
                    logger.log(Level.INFO, "Create command..." + Arrays.toString(arguments.split(" ", 1)));


                    Factory.getInstance();

                    command = Factory.getInstance().makeCommand(arguments.split(" "));
                    if(command != null){
                        command.doCommand(context, arguments.split(" "));
                    }
                }
            }
            catch (CalculatorException ex){
                logger.log(Level.WARNING, "Calculator Error:", ex);
            }
            catch (ArithmeticException ex){
                logger.log(Level.WARNING,"Arithmetic error:", ex);
            }
            catch (IOException ex){
                logger.log(Level.SEVERE, "Error during reading input!");
                break;
            }
        }
    }

}