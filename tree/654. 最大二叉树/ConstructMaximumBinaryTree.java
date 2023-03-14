class ConstructMaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int l, int r) {
		if (l > r) return null;
		// find max
		int maxValue = Integer.MIN_VALUE, maxIndex = 0;
		for (int i = l; i <= r; i++) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				maxIndex = i;
			}
		}
		// construct
		TreeNode root = new TreeNode(maxValue);
		root.left = build(nums, l, maxIndex - 1);
		root.right = build(nums, maxIndex + 1, r);
		return root;
	}
}