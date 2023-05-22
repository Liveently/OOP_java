package lab2.Commands;

import lab2.Commands.Command;
import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.wrongAmountOfArgsException;
import lab2.Exceptions.wrongFormatValueException;


public class SQRT implements Command {

    @Override
    public void doCommand(Context context, String[] arguments) throws CalculatorException {
        double value;

        if(arguments.length != 1){
            throw new wrongAmountOfArgsException("Not enough args for SQRT");
        }
        value = context.pop();
        if(value >= 0){
            context.push(Math.sqrt(value));
        }else{
            throw new wrongFormatValueException("Sqrt from negative number cannot be got!");
        }
    }
}