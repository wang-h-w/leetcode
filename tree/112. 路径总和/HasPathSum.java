class HasPathSum {
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

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) return false;
		return path(root, targetSum);
	}

	private boolean path(TreeNode root, int targetSum) {
		if (root == null) {
			if (targetSum == 0) return true;
			else return false;
		}
		if (root.left == null) return path(root.right, targetSum - root.val);
		else if (root.right == null) return path(root.left, targetSum - root.val);
		return path(root.left, targetSum - root.val) || path(root.right, targetSum - root.val);
	}

	public static void main(String[] args) {
		HasPathSum path = new HasPathSum();
		TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), 
			new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, 
			new TreeNode(1))));
		System.out.println(path.hasPathSum(root, 22));
	}
}