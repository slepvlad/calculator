import java.util.*;

class Calculate {
    private static String operation = "+-/*";
    private String incoming;


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


    private List<String> parse(){
        List<String> output = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        StringTokenizer tokenizer = new StringTokenizer(incoming, operation, true);
        String current;
        while (tokenizer.hasMoreTokens()){

            current = tokenizer.nextToken();
            if(current.equals(" ")){
                continue;
            }
            if(isOperation(current)){
                if(stack.isEmpty()){stack.push(current);}
                else{
                    while (!stack.isEmpty() && (priority(current)>= priority(stack.peek()))){
                        output.add(stack.pop());
                    }
                    stack.push(current);
                }
                continue;
            }
            output.add(current);
        }
        while (!stack.isEmpty()){
            output.add(stack.pop());
        }
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
