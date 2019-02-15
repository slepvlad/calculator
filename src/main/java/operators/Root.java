package operators;

import java.util.Deque;

public class Root implements Operator {
    @Override
    public void calculate(Deque<Double> stack) {
        Double second = stack.pop();
        Double first = stack.pop();
        stack.push(Math.pow(first, 1/second));
    }
}
