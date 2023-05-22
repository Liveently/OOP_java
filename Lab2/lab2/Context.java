package lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    private final Stack<Double> stack = new Stack<>();
    private final Map<String, Double> map = new HashMap<>();

    public Double pop(){
        return stack.pop();
    }

    public void putVariable(String variable, Double value){
        if(map.containsKey(variable)){
            map.replace(variable, value);
        }else{
            map.put(variable, value);
        }
    }

    public Double getVariableVal(String variable){
        return map.get(variable);
    }

    public boolean isVariableInStack(String variable){
        return map.containsKey(variable);
    }

    public int stackSize(){
        return stack.size();
    }

    public void push(Double num){
        stack.push(num);
    }

    public Double peek_stack(){

        return stack.peek();
    }
}