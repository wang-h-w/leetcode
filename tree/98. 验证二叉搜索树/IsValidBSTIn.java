class IsValidBSTIn {
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

	long prev = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		if (!isValidBST(root.left)) return false;
		if (prev >= root.val) return false;
		prev = root.val;
		return isValidBST(root.right);
	}

	public static void main(String[] args) {
		IsValidBSTIn bst = new IsValidBSTIn();
		TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
		System.out.println(bst.isValidBST(root));
	}
}