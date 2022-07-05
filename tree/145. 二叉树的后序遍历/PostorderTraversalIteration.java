import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

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

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.empty() || root != null) {
			while (root != null) {
				stack.push(root);
				ret.add(0, root.val);
				root = root.right;
			}
			root = stack.pop();
			root = root.left;
		}

		return ret;
	}

	public static void main(String[] args) {
		PostorderTraversal post = new PostorderTraversal();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(post.postorderTraversal(root));
	}
}