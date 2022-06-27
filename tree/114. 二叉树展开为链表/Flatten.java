class Flatten {
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

	private TreeNode curr;

	public void flatten(TreeNode root) {
		if (root == null) return;
		curr = root.left;
		if (curr != null) {
			while (curr.right != null) curr = curr.right;
			curr.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		flatten(root.right);
	}

	private static void printHelper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return;
		if (root.left != null) System.out.print(root.left.val + " ");
		else System.out.print("#" + " ");
		if (root.right != null) System.out.print(root.right.val + " ");
		else System.out.print("#" + " ");
		printHelper(root.left);
		printHelper(root.right);
	}

	public static void main(String[] args) {
		Flatten f = new Flatten();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
		// root = new TreeNode(0);
		f.flatten(root);
		System.out.print(root.val + " ");
		printHelper(root);
	}
}