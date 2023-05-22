package lab2.Commands;

import lab2.Commands.Command;
import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.wrongAmountOfArgsException;
import lab2.Exceptions.wrongFormatValueException;


public class PUSH implements Command {

    @Override
    public void doCommand(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 2){
            throw new wrongAmountOfArgsException("Not enough arguments for PUSH");
        }

        try{
            context.push(Double.parseDouble(arguments[1]));
        }
        catch (NumberFormatException ex){
            if(context.isVariableInStack(arguments[1]))
                context.push (context.getVariableVal(arguments[1]));
            else {
                throw new wrongFormatValueException("Wrong value for PUSH");
            }
        }
    }
}
