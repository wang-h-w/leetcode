class IsValidBST {
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

	public boolean isValidBST(TreeNode root) {
		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validate(TreeNode root, long min, long max) {
		if (root == null) return true;
		if (root.val <= min || root.val >= max) return false;
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}

	public static void main(String[] args) {
		IsValidBST bst = new IsValidBST();
		TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
		System.out.println(bst.isValidBST(root));
	}
}