class Solution {
	private boolean flag = true;
	
	public boolean isBalanced(TreeNode root) {
		maxDepth(root);
		return flag;
	}
	
	private int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (Math.abs(left - right) > 1) flag = false;
		return 1 + Math.max(left, right);
	}
}