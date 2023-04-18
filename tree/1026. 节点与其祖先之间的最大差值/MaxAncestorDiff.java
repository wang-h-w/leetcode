class MaxAncestorDiff {
	private int res = 0;

	public int maxAncestorDiff(TreeNode root) {
		getMaxAndMin(root);
		return res;
	}

	private int[] getMaxAndMin(TreeNode node) {
		if (node == null) return new int[] {-1, -1};
		int[] l = getMaxAndMin(node.left), r = getMaxAndMin(node.right);
		int[] curr = new int[] {node.val, node.val};
		if (l[0] != -1) {
			res = Math.max(res, Math.max(Math.abs(node.val - l[0]), Math.abs(node.val - l[1])));
			curr[0] = Math.min(curr[0], l[0]);
			curr[1] = Math.max(curr[1], l[1]);
		}
		if (r[0] != -1) {
			res = Math.max(res, Math.max(Math.abs(node.val - r[0]), Math.abs(node.val - r[1])));
			curr[0] = Math.min(curr[0], r[0]);
			curr[1] = Math.max(curr[1], r[1]);
		}
		return curr;
	}
}