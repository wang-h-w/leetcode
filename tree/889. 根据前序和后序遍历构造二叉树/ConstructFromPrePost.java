class ConstructFromPrePost {
	private Map<Integer, Integer> map;

	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		map = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) map.put(postorder[i], i);
		return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
		if (preStart > preEnd) return null;
		if (preStart == preEnd) return new TreeNode(preorder[preStart]);
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = map.get(preorder[preStart + 1]);
		root.left = build(preorder, preStart + 1, preStart + 1 + index - postStart, postorder, postStart, index);
		root.right = build(preorder, preStart + 1 + index - postStart + 1, preEnd, postorder, index + 1, postEnd - 1);
		return root;
	}
}