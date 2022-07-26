import java.util.Stack;

class MyQueue {
	Stack<Integer> in;
	Stack<Integer> out;

	public MyQueue() {
		in = new Stack<>();
		out = new Stack<>();
	}

	public void push(int x) {
		while (!in.isEmpty()) out.push(in.pop());
		out.push(x);
		while (!out.isEmpty()) in.push(out.pop());
	}

	public int pop() {
		return in.pop();
	}

	public int peek() {
		return in.peek();
	}

	public boolean empty() {
		return in.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.empty());
		System.out.println(q.pop());
		System.out.println(q.empty());
		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.empty());
	}
}