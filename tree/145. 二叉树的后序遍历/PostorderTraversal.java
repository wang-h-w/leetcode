import java.util.List;
import java.util.LinkedList;

class PostorderTraversal {
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
	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) return ret;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		ret.add(root.val);
		return ret;
	}

	public static void main(String[] args) {
		PostorderTraversal post = new PostorderTraversal();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(post.postorderTraversal(root));
	}
}