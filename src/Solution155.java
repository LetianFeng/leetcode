import java.util.Stack;

public class Solution155 {

    Stack<Integer> stack;
    Stack<Integer> mins;

    /** initialize your data structure here. */
    public Solution155() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (mins.isEmpty() || x <= mins.peek())
            mins.push(x);
    }

    public void pop() {
        if ((int)stack.pop() == mins.peek())
            mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */