class LongestUnivaluePath {
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

	private int maxLength;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) return 0;
		maxLength = 0;
		longestHelper(root, root.val);
		return maxLength;
	}

	private int longestHelper(TreeNode root, int currVal) {
		if (root == null) return 0;
		int left = longestHelper(root.left, root.val);
		int right = longestHelper(root.right, root.val);
		maxLength = Math.max(maxLength, left + right);
		if (root.val == currVal) return Math.max(left, right) + 1;
		return 0;
	}

	public static void main(String[] args) {
		LongestUnivaluePath univalue = new LongestUnivaluePath();
		TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)), new TreeNode(5, null, new TreeNode(5)));
		System.out.println(univalue.longestUnivaluePath(root));
		root = new TreeNode(1, new TreeNode(4, new TreeNode(4), new TreeNode(4)), new TreeNode(5, null, new TreeNode(5)));
		System.out.println(univalue.longestUnivaluePath(root));
		root = new TreeNode(1, null, new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)), new TreeNode(1, new TreeNode(1), null)));
		System.out.println(univalue.longestUnivaluePath(root));
	}
}