package lab2.Commands;

import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.Wrong_amount_of_args_exception;


public class COMMENT implements Command {

    @Override
    public void do_command(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length < 2){
            throw new Wrong_amount_of_args_exception("This is empty commentary!");
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