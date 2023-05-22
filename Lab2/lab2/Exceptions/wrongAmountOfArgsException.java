package lab2.Exceptions;


public class wrongAmountOfArgsException extends CalculatorException{
    public wrongAmountOfArgsException(String str){
        super(str);
    }

    public wrongAmountOfArgsException(){}

    public wrongAmountOfArgsException(String str, Throwable cause){
        super(str, cause);
    }

    public wrongAmountOfArgsException(Throwable cause){
        super(cause);
    }
}