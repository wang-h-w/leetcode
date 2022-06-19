import java.util.List;
import java.util.LinkedList;

class InorderTraversal {
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

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) return ret;
		inorderTraversal(root.left);
		ret.add(root.val);
		inorderTraversal(root.right);
		return ret;
	}

	public static void main(String[] args) {
		InorderTraversal inorder = new InorderTraversal();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(inorder.inorderTraversal(root));
	}
}