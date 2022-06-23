class RecoverTree {
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

	private TreeNode x = null;
	private TreeNode y = null;
	private TreeNode prev = null;

	public void recoverTree(TreeNode root) {
		dfs(root);
		if (x != null && y != null) {
			int temp = x.val;
			x.val = y.val;
			y.val = temp;
		}
	}

	private void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.left);
		if (prev == null) prev = root;
		else {
			if (prev.val > root.val) {
				y = root;
				if (x == null) x = prev;
			}
			prev = root;
		}
		dfs(root.right);
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
		RecoverTree rt = new RecoverTree();
		TreeNode tree = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
		tree = new TreeNode(2, new TreeNode(3), new TreeNode(1));
		System.out.print(tree.val + " ");
		rt.recoverTree(tree);
		printHelper(tree);
	}
}