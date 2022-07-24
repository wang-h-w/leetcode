import java.util.Queue;
import java.util.LinkedList;

class MyStack {
	Queue<Integer> in;
	Queue<Integer> out;

	public MyStack() {
		in = new LinkedList<>();
		out = new LinkedList<>();
	}

	public void push(int x) {
		in.offer(x);
		while (!out.isEmpty()) in.offer(out.poll());
		Queue temp = in;
		in = out;
		out = temp;
	}

	public int pop() {
		return out.poll();
	}

	public int top() {
		return out.peek();
	}

	public boolean empty() {
		return out.isEmpty();
	}

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.top()); // 返回 2
		System.out.println(myStack.pop()); // 返回 2
		System.out.println(myStack.empty()); // 返回 False
		System.out.println(myStack.pop()); // 返回 1
	}
}