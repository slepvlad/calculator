package operators;

import java.util.Deque;

public class Pow implements Operator {
    @Override
    public void calculate(Deque<Double> stack) {
        Double second = stack.pop();
        Double first = stack.pop();
        stack.push(Math.pow(first, second));
    }
}
