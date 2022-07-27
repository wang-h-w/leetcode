import java.util.Stack;

class LowestCommonAncestor {
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

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int mul = (root.val - p.val) * (root.val - q.val);
		if (mul <= 0) return root;
		else if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
		else return lowestCommonAncestor(root.right, p, q);
	}
}