package lab2.Commands;


import lab2.Context;
import lab2.Exceptions.CalculatorException;
import lab2.Exceptions.Wrong_amount_of_args_exception;
import lab2.Exceptions.Wrong_format_value_exception;

public class DEFINE implements Command {

    @Override
    public void do_command(Context context, String[] arguments) throws CalculatorException {
        if(arguments.length != 3){
            throw new Wrong_amount_of_args_exception("Wrong count of args for DEFINE command");
        }
        try{
            context.put_variable(arguments[1], Double.parseDouble(arguments[2]));
        }
        catch (NumberFormatException ex){
            throw new Wrong_format_value_exception("Wrong value for variable to DEFINE");
        }
    }
}