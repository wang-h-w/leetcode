class DiameterOfBinaryTree {
	private int maxD = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return maxD;
	}
	
	private int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		maxD = Math.max(maxD, left + right);
		return 1 + Math.max(left, right);
	}
}