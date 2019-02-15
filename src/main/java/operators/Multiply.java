package operators;

import java.util.Deque;

public class Multiply implements Operator {
    public static final String OPERATION_SIGN = "*";
    private static final int PRIORITY = 1;

    @Override
    public void calculate(Deque<Double> stack) {
        Double second = stack.pop();
        Double first = stack.pop();
        stack.push(first * second);
    }

    @Override
    public int getPRIORITY() {
        return PRIORITY;
    }
}
