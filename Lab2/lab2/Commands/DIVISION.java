package lab2.Commands;

import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.Stack_size_exception;
import lab2.Exceptions.Wrong_amount_of_args_exception;

public class DIVISION implements Command {

    @Override
    public void do_command(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 1){
            throw new Wrong_amount_of_args_exception("Wrong count of args for DIVISION command");
        }

        if(context.stack_size() < 2){
            throw new Stack_size_exception("Not enough values in stack for DIVISION");
        }


        if(context.stack_size() >= 2){
            context.push(context.pop() / context.pop());
        }

    }
}