package lab2.Commands;



import lab2.Context;
import lab2.Exceptions.CalculatorException;

public interface Command {
    void do_command(Context context, String[] arguments) throws CalculatorException;
}