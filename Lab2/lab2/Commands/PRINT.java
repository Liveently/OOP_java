package lab2.Commands;

import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.Stack_size_exception;
import lab2.Exceptions.Wrong_amount_of_args_exception;


public class PRINT implements Command {

    @Override
    public void do_command(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 1){
            throw new Wrong_amount_of_args_exception("Not a valid command!");
        }
        else if(context.stack_size() > 0)
            System.out.println(context.peek_stack());
        else{
            throw new Stack_size_exception("Stack is empty!");
        }
    }
}
