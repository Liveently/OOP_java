package lab2.Commands;

import lab2.Commands.Command;
import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.stackSizeException;
import lab2.Exceptions.wrongAmountOfArgsException;

public class DIFF implements Command {

    @Override
    public void doCommand(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 1){
            throw new wrongAmountOfArgsException("Wrong count of args for DIFF command");
        }else if(context.stackSize() >= 2){
            context.push(context.pop() - context.pop());
        }else{
            throw new stackSizeException("Not enough values in stack");
        }
    }
}