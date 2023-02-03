class BtreeGameWinningMove {
	private int x, lsz, rsz;

	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		this.x = x;
		dfs(root);
		return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;
	}

	private int dfs(TreeNode node) {
		if (node == null) return 0;
		int ls = dfs(node.left);
		int rs = dfs(node.right);
		if (node.val == x) {
			lsz = ls;
			rsz = rs;
		}
		return ls + rs + 1;
	}
}