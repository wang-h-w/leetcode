class SortedArrayToBST {
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

	int[] nums;
	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;
		return sort(0, nums.length - 1);
	}

	private TreeNode sort(int start, int end) {
		if (start > end) return null;
		int center = (start + end) / 2;
		TreeNode root = new TreeNode(this.nums[center]);
		root.left = sort(start, center - 1);
		root.right = sort(center + 1, end);
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
		SortedArrayToBST s = new SortedArrayToBST();
		int[] nums = new int[] {-10, -3, 0, 5, 9};
		nums = new int[] {1};
		TreeNode root = s.sortedArrayToBST(nums);
		System.out.print(root.val + " ");
		printHelper(root);
	}
}