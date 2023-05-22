package lab2.Exceptions;

public class wrongFormatValueException extends CalculatorException {
    public wrongFormatValueException(String str){
        super(str);
    }

    public wrongFormatValueException(){}

    public wrongFormatValueException(String str, Throwable cause){
        super(str, cause);
    }

    public wrongFormatValueException(Throwable cause){
        super(cause);
    }
}