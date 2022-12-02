class PathSum {
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

	Map<Long, Integer> map = new HashMap<>();
	int ans, target;

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		target = targetSum;
		map.put(0L, 1);
		dfs(root, root.val);
		return ans;
	}

	private void dfs(TreeNode root, long val) {
		ans += map.getOrDefault(val - target, 0);
		map.put(val, map.getOrDefault(val, 0) + 1);
		if (root.left != null) dfs(root.left, val + root.left.val);
		if (root.right != null) dfs(root.right, val + root.right.val);
		map.put(val, map.getOrDefault(val, 0) - 1); // 防止统计跨越左右子树
	}
}