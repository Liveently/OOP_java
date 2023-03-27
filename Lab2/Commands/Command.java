package lab2.Commands;

//Интерфейс команд, классы определенных команд имплицируют данный интерфейс
//Метод Do_command перегружен в реализации каждого класса отдельной команды

import lab2.Context;
import lab2.Exceptions.CalculatorException;

public interface Command {
    void do_command(Context context, String[] arguments) throws CalculatorException;
}