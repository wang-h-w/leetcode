import java.util.Deque;
import java.util.LinkedList;

class MinStack {
	private Node sentinel;
	private Deque<Node> stack;

    public MinStack() {
    	sentinel = new Node(0, Integer.MAX_VALUE);
    	stack = new LinkedList<>();
    	stack.push(sentinel);
    }
    
    public void push(int x) {
    	stack.push(new Node(x, Math.min(x, this.min())));
    }
    
    public void pop() {
    	stack.pop();
    }
    
    public int top() {
    	return stack.peek().getVal();
    }
    
    public int min() {
    	return stack.peek().getMin();
    }

    private static class Node {
    	private int val;
    	private int min;

    	Node (int _val, int _min) {
    		val = _val;
    		min = _min;
    	}

    	public int getVal() {
    		return val;
    	}

    	public int getMin() {
    		return min;
    	}
    }
}