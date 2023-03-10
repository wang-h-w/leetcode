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

	Map<TreeNode, Integer> memo = new HashMap<>();

	public int rob(TreeNode root) {
	    if (root == null) return 0;
	    if (memo.containsKey(root)) return memo.get(root);
	    int did = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
	    					 (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
	    int didnot = rob(root.left) + rob(root.right);
	    int res = Math.max(did, didnot);
	    memo.put(root, res);
	    return res;
	}

	public static void main(String[] args) {
		Rob r = new Rob();
		System.out.println(r.rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
		System.out.println(r.rob(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)))));
	}
}