import java.util.Stack;

class BSTIterator {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public int next() {
		TreeNode node = stack.pop();
		int res = node.val;
		node = node.right;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		return res;
	}

	public boolean hasNext() {
		return !stack.empty();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
		BSTIterator bst = new BSTIterator(root);
		System.out.print(bst.next() + " ");
		System.out.print(bst.next() + " ");
		System.out.print(bst.hasNext() + " ");
		System.out.print(bst.next() + " ");
		System.out.print(bst.hasNext() + " ");
		System.out.print(bst.next() + " ");
		System.out.print(bst.hasNext() + " ");
		System.out.print(bst.next() + " ");
		System.out.print(bst.hasNext() + " ");
	}
}