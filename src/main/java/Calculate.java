
import operators.*;

import java.util.*;

class Calculate {
    private static final Map <String, Operator> OPERATORS_MAP = new HashMap<>();
    private static String hiPriorityOperation = "/*^@";
    private static String lowPriorityOperation = "+-";
    private static String operation = hiPriorityOperation + lowPriorityOperation;
    private String incoming;
    private List<String> output = new ArrayList<>();
    private Deque<String> stack = new ArrayDeque<>();

    static {
        OPERATORS_MAP.put("+", new Add());
        OPERATORS_MAP.put("-", new Subtraction());
        OPERATORS_MAP.put("*", new Multiply());
        OPERATORS_MAP.put("/", new Division());
        OPERATORS_MAP.put("^", new Pow());
        OPERATORS_MAP.put("@", new Root());
    }
    Calculate(String incoming) {
        this.incoming = incoming.replaceAll(" ","");
    }

    private boolean isOperation(String str){
        for(int i = 0; i < operation.length(); i++){
            if(str.charAt(0) == operation.charAt(i)){
                return true;
            }
        }
        return false;
    }

    private static int priority(String str) {
        if(hiPriorityOperation.contains(str)){return 1;}
        else {return 2;}
    }

    private void parseOperation(String str){
        if(stack.isEmpty()){
            stack.push(str);
        }
        else{
            while (!stack.isEmpty() && (priority(str)>= priority(stack.peek()))){
                output.add(stack.pop());
            }
            stack.push(str);
        }

    }

    private void toEmptyStack(){
        while (!stack.isEmpty()){
            output.add(stack.pop());
        }
    }


    private List<String> parse(){

        StringTokenizer tokenizer = new StringTokenizer(incoming, operation, true);
        String current;
        while (tokenizer.hasMoreTokens()){
            current = tokenizer.nextToken();

            if(isOperation(current)){
                parseOperation(current);
            } else{
                output.add(current);
            }
        }
        toEmptyStack();

        return output;
    }

    private String calculate(){
        Deque<Double> stack = new ArrayDeque<>();
        List<String> input = this.parse();
        Operator doCalculate;
        for(String x: input){
            if(isOperation(x)){
                doCalculate = OPERATORS_MAP.get(x);
                doCalculate.calculate(stack);
            }
            else{stack.push(Double.parseDouble(x.trim()));}
        }

        return stack.pop().toString();
    }

   public String getResult(){
        return this.calculate();
    }
}
