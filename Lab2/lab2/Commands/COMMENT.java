package lab2.Commands;

import lab2.Commands.Command;
import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.wrongAmountOfArgsException;


public class COMMENT implements Command {

    @Override
    public void doCommand(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length < 2){
            throw new wrongAmountOfArgsException("This is empty commentary!");
        }
        else{
            for(int i = 1; i < arguments.length; i++){
                System.out.print(arguments[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}