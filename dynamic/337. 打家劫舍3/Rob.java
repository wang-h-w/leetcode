class Rob {
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

	public int rob(TreeNode root) {
	    int[] result = robInternal(root);
	    return Math.max(result[0], result[1]);
	}

	private int[] robInternal(TreeNode root) {
		// 二维数组：0表示不偷当前节点能获得的最大金额，1表示偷当前节点能获得的最大金额
	    if (root == null) return new int[2];
	    int[] result = new int[2];

	    int[] left = robInternal(root.left);
	    int[] right = robInternal(root.right);

	    result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    result[1] = left[0] + right[0] + root.val;

	    return result;
	}

	public static void main(String[] args) {
		Rob r = new Rob();
		System.out.println(r.rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
		System.out.println(r.rob(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)))));
	}
}