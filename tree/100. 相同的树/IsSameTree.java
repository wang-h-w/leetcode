class IsSameTree {
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

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val != q.val) return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		IsSameTree same = new IsSameTree();
		TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
		TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
		System.out.println(same.isSameTree(p, q));
	}
}