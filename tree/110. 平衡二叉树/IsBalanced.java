class IsBalanced {
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

	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return treeSize(root) >= 0;
	}

	private int treeSize(TreeNode node) {
		if (node == null) return 0;
		int left = treeSize(node.left), right = treeSize(node.right);
		if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
		else return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		IsBalanced b = new IsBalanced();
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(b.isBalanced(root));
	}
}