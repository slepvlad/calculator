package operators;

import java.util.Deque;

public class Add implements Operator {
    @Override
    public void calculate(Deque<Double> stack) {
        Double second = stack.pop();
        Double first = stack.pop();
        stack.push(first + second);
    }
}
