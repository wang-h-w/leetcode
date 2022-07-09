class MinStack {
	static class Node {
		int val;
		Node next;
		int min;
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	Node list;
	int min;

	public MinStack() {
		list = null;
		min = Integer.MIN_VALUE;
	}

	public void push(int val) {
		list = new Node(val, list);
		if (list.next != null) list.min = val < list.next.min ? val : list.next.min;
		else list.min = val;
	}

	public void pop() {
		list = list.next;
	}

	public int top() {
		return list.val;
	}

	public int getMin() {
		return list.min;
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
 		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.print(obj.getMin() + " ");
		obj.pop();
		System.out.print(obj.top() + " ");
		System.out.print(obj.getMin() + " ");
	}
}