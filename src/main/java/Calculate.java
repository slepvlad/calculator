
import operators.*;

import java.util.*;

class Calculate {
    private static final Map <String, Operator> OPERATORS_MAP = new HashMap<>();
   // private static String hiPriorityOperation = "/*^@";
   //private static String lowPriorityOperation = "+-";
    private static String operation;
    private String incoming;
    private List<String> output = new ArrayList<>();
    private Deque<String> stack = new ArrayDeque<>();

    static {
        OPERATORS_MAP.put(Add.OPERATION_SIGN, new Add());
        OPERATORS_MAP.put(Subtraction.OPERATION_SIGN, new Subtraction());
        OPERATORS_MAP.put(Multiply.OPERATION_SIGN, new Multiply());
        OPERATORS_MAP.put(Division.OPERATION_SIGN, new Division());
        OPERATORS_MAP.put(Pow.OPERATION_SIGN, new Pow());
        OPERATORS_MAP.put(Root.OPERATION_SIGN, new Root());
        operation = getOperation();
    }
    Calculate(String incoming) {
        this.incoming = incoming.replaceAll(" ","");
    }


    private static String getOperation(){
        StringBuffer strOperation = new StringBuffer();
        for(Map.Entry<String, Operator> entry: OPERATORS_MAP.entrySet()){
            strOperation.append(entry.getKey());
        }
        return strOperation.toString();
    }

    private boolean isOperation(String str){
        return operation.contains(str);
    }

    private static int priority(String str) {
        int result = 3;
        for(Map.Entry<String, Operator> entry : OPERATORS_MAP.entrySet()){
            if(entry.getKey().equals(str)){
                result =  entry.getValue().getPRIORITY();
            }
        }
        return result;
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
