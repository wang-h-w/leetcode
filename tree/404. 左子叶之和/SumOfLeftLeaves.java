class SumOfLeftLeaves {
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
	
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) return 0;
		TreeNode leftNode = root.left;
		if (leftNode != null && leftNode.left == null && leftNode.right == null) {
			return leftNode.val + sumOfLeftLeaves(root.right);
		}
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
}