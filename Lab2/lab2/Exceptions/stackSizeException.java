package lab2.Exceptions;


public class stackSizeException extends CalculatorException{

    public stackSizeException(String str){
        super(str);
    }

    public stackSizeException(){}

    public stackSizeException(String str, Throwable cause){
        super(str, cause);
    }

    public stackSizeException(Throwable cause){
        super(cause);
    }
}