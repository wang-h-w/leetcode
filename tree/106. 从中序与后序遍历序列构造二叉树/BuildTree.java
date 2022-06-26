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

	private int[] inorder;
	private int[] postorder;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.inorder = inorder;
		this.postorder = postorder;
		return build(0, inorder.length - 1, 0, postorder.length - 1);
	}

	private TreeNode build(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) return null;
		TreeNode root = new TreeNode(postorder[postEnd]);
		for (int i = inStart; i <= inEnd; i++) {
			if (postorder[postEnd] == inorder[i]) {
				root.left = build(inStart, i - 1, postStart, postStart + i - inStart - 1);
				root.right = build(i + 1, inEnd, postStart + i - inStart, postEnd - 1);
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
		int[] inorder = new int[] {9,3,15,20,7};
		int[] postorder = new int[] {9,15,7,20,3};
		TreeNode result = bt.buildTree(inorder, postorder);
		System.out.print(result.val + " ");
		printHelper(result);
	}
}