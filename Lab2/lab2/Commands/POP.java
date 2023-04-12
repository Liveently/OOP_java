package lab2.Commands;

import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.Stack_size_exception;
import lab2.Exceptions.Wrong_amount_of_args_exception;


public class POP implements Command {

    @Override
    public void do_command(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 1){
            throw new Wrong_amount_of_args_exception("Wrong count of args for POP command");
        } else if(context.stack_size() > 0)
            context.pop();
        else {
            throw new Stack_size_exception("Stack is empty");
        }
    }
}