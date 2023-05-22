package lab2.Commands;

import lab2.Commands.Command;
import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.stackSizeException;
import lab2.Exceptions.wrongAmountOfArgsException;


public class POP implements Command {

    @Override
    public void doCommand(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 1){
            throw new wrongAmountOfArgsException("Wrong count of args for POP command");
        } else if(context.stackSize() > 0)
            context.pop();
        else {
            throw new stackSizeException("Stack is empty");
        }
    }
}