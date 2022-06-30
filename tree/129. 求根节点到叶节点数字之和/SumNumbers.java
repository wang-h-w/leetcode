class SumNumbers {
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

	int sum = 0;
	public int sumNumbers(TreeNode root) {
		dfs(root, 0);
		return sum;
	}

	private void dfs(TreeNode curr, int value) {
		if (curr == null) return;
		int t = value * 10 + curr.val;
		if (curr.left == null && curr.right == null) sum += t;
		dfs(curr.left, t);
		dfs(curr.right, t);
	}

	public static void main(String[] args) {
		SumNumbers sum = new SumNumbers();
		TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
		System.out.println(sum.sumNumbers(root));
	}
}