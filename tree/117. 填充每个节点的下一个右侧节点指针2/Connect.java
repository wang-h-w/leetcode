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
		if (root.left != null && root.right != null) root.left.next = root.right;
		if (root.left != null && root.right == null) root.left.next = findNext(root.next);
		if (root.right != null) root.right.next = findNext(root.next);
		connect(root.right);
		connect(root.left);
		return root;
	}

	private Node findNext(Node root) {
		if (root == null) return null;
		if (root.left != null) return root.left;
		if (root.right != null) return root.right;
		if (root.next != null) return findNext(root.next);
		return null;
	}

	public static void main(String[] args) {
		Connect c = new Connect();
		Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), 
			new Node(3, new Node(6), new Node(7), null), null);
		Node result = c.connect(root);
	}
}