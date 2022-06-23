class IsSymmetric {
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

	public boolean isSymmetric(TreeNode root) {
		return checkSymmetric(root.left, root.right);
	}

	private boolean checkSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val != right.val) return false;
		return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
	}

	public static void main(String[] args) {
		IsSymmetric is = new IsSymmetric();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
		root = new TreeNode(10, new TreeNode(2), null);
		System.out.println(is.isSymmetric(root));
	}
}