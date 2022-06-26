class BuildTree {
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

	private int[] preorder;
	private int[] inorder;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) return null;
		this.preorder = preorder;
		this.inorder = inorder;
		return build(0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode build(int preStart, int preEnd, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		for (int i = inStart; i <= inEnd; i++) {
			if (preorder[preStart] == inorder[i]) {
				root.left = build(preStart + 1, preStart + i - inStart, inStart, i - 1);
				root.right = build(preStart + i - inStart + 1, preEnd, i + 1, inEnd);
				break;
			}
		}
		return root;
	}

	private static void printHelper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return;
		if (root.left != null) System.out.print(root.left.val + " ");
		else System.out.print("#" + " ");
		if (root.right != null) System.out.print(root.right.val + " ");
		else System.out.print("#" + " ");
		printHelper(root.left);
		printHelper(root.right);
	}

	public static void main(String[] args) {
		BuildTree bt = new BuildTree();
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7};
		TreeNode result = bt.buildTree(preorder, inorder);
		System.out.print(result.val + " ");
		printHelper(result);
	}
}