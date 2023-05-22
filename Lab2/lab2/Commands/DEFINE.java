package lab2.Commands;


import lab2.Commands.Command;
import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.wrongAmountOfArgsException;
import lab2.Exceptions.wrongFormatValueException;

public class DEFINE implements Command {

    @Override
    public void doCommand(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 3){
            throw new wrongAmountOfArgsException("Wrong count of args for DEFINE command");
        }
        try{
            context.putVariable(arguments[1], Double.parseDouble(arguments[2]));
        }
        catch (NumberFormatException ex){
            throw new wrongFormatValueException("Wrong value for variable to DEFINE");
        }
    }
}