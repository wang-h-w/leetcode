import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

class PreorderTraversalIterative {
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

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				ret.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		return ret;
	}

	public static void main(String[] args) {
		PreorderTraversalIterative pre = new PreorderTraversalIterative();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(pre.preorderTraversal(root));
	}
}