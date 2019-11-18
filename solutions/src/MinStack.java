import java.util.Stack;

public class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> regularStack;
    private Integer min;
    public MinStack() {
        minStack = new Stack<>();
        regularStack = new Stack<>();
        min = null;
    }

    public void push(int x) {
        regularStack.push(x);
        if (min == null || min >= x) {
            minStack.push(x);
            min = x;
        }
    }
    public int getMin() {
        return min;
    }
    public int top() {
        return regularStack.peek();
    }
    public int pop() {
        int toRemove = regularStack.pop();
        if (min == toRemove) {
            if (regularStack.size() == 0) {
                minStack.pop();
                min = null;
            }
            else {
                minStack.pop();
                min = minStack.peek();
            }
        }
        return toRemove;
    }
}
