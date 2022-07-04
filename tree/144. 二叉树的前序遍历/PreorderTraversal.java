import java.util.List;
import java.util.LinkedList;

class PreorderTraversal {
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

	List<Integer> ret = new LinkedList<>();
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) return ret;
		ret.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return ret;
	}

	public static void main(String[] args) {
		PreorderTraversal pre = new PreorderTraversal();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(pre.preorderTraversal(root));
	}
}