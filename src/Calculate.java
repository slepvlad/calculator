import java.util.*;

class Calculate {
    private static String operation = "+-/*";
    private String incoming;
    private List<String> output = new ArrayList<>();
    private Deque<String> stack = new ArrayDeque<>();

    Calculate(String incoming) {
        this.incoming = incoming;
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
        if(str.equals("*")||str.equals("/")){return 1;}
        if(str.equals("+")||str.equals("-")){return 2;}
        return 3;
    }

    private void parseOperation(String str){
        if(stack.isEmpty()){stack.push(str);}
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

        StringTokenizer tokenizer = new StringTokenizer(incoming.replaceAll(" ",""), operation, true);
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
        for(String x: input){
            switch (x) {
                case "*": {
                    Double second = stack.pop();
                    Double first = stack.pop();
                    stack.push(first * second);
                    break;
                }
                case "/": {
                    Double second = stack.pop();
                    Double first = stack.pop();
                    stack.push(first / second);
                    break;
                }
                case "-": {
                    Double second = stack.pop();
                    Double first = stack.pop();
                    stack.push(first - second);
                    break;
                }
                case "+": {
                    Double second = stack.pop();
                    Double first = stack.pop();
                    stack.push(first + second);
                    break;
                }
                default:
                    stack.push(Double.parseDouble(x.trim()));
                    break;
            }

        }

        return stack.pop().toString();
    }

    String getResult(){
        return this.calculate();
    }
}
