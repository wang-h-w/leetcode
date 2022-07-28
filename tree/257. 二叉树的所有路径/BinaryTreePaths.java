import java.util.List;
import java.util.LinkedList;

class BinaryTreePaths {
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

	List<String> ret = new LinkedList<>();
	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) return ret;
 		backtrack(root, "");
		return ret;
	}

	private void backtrack(TreeNode root, String path) {
		if (root == null) return;	
		path += root.val;
		if (root.left == null && root.right == null) {
			ret.add(path);
			return;
		}
		backtrack(root.left, path + "->");
		backtrack(root.right, path + "->");
	} 

	public static void main(String[] args) {
		BinaryTreePaths b = new BinaryTreePaths();
		// TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
		// System.out.println(b.binaryTreePaths(root));
		TreeNode root = new TreeNode(1);
		System.out.println(b.binaryTreePaths(root));
	}
}