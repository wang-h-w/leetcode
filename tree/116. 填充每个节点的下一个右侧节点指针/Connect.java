import java.util.List;
import java.util.LinkedList;
import java.util.Deque;

class Connect {
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}
		public Node(int _val) {
			val = _val;
		}
		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		if (root == null) return null;
		Deque<Node> deque = new LinkedList<>();
		deque.add(root);
		int count = 1;
		Node prev = null, curr = null;

		while (deque.size() != 0) {
			curr = deque.poll();
			if (curr.left != null) deque.add(curr.left);
			if (curr.right != null) deque.add(curr.right);
			
			if (prev != null) prev.next = curr;
			if (--count != 0) {
				prev = curr;
			} else {
				prev = null;
				count = deque.size();
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Connect c = new Connect();
		Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), 
			new Node(3, new Node(6), new Node(7), null), null);
		Node result = c.connect(root);
	}
}