import java.util.Stack;

class StockSpanner {
	Stack<Integer> stockStack;
	Stack<Integer> numStack;

	public StockSpanner() {
		stockStack = new Stack<>();
		numStack = new Stack<>();
	}

	public int next(int price) {
		int temp = 1;
		while (!stockStack.isEmpty() && stockStack.peek() <= price) {
			stockStack.pop();
			temp += numStack.pop();
		}
		stockStack.push(price);
		numStack.push(temp);
		return numStack.peek();
	}

	public static void main(String[] args) {
		StockSpanner ss = new StockSpanner();
		System.out.print(ss.next(100) + " ");
		System.out.print(ss.next(80) + " ");
		System.out.print(ss.next(60) + " ");
		System.out.print(ss.next(70) + " ");
		System.out.print(ss.next(60) + " ");
		System.out.print(ss.next(75) + " ");
		System.out.print(ss.next(85) + " ");
	}
}