class CountNodes {
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

	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int left = count(root.left);
		int right = count(root.right);
		if (left == right) return countNodes(root.right) + (1 << left);
		else return countNodes(root.left) + (1 << right);
	}

	private int count(TreeNode root) {
		int level = 0;
		while (root != null) {
			level++;
			root = root.left;
		}
		return level;
	}

	public static void main(String[] args) {
		CountNodes c = new CountNodes();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
		System.out.println(c.countNodes(root));
	}
}