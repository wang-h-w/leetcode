import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

class InorderTraversalStack {
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

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			ret.add(root.val);
			root = root.right;
		}
		return ret;
	}

	public static void main(String[] args) {
		InorderTraversalStack inorder = new InorderTraversalStack();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(inorder.inorderTraversal(root));
	}
}