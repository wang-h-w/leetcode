import java.util.List;
import java.util.LinkedList;

class PathSum {
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

	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null) return ret;
		dfs(root, targetSum);
		return ret;
	}

	private void dfs(TreeNode root, int targetSum) {
		if (root == null) {
			if (targetSum == 0) ret.add(new LinkedList<>(path));
			return;
		}
		path.add(root.val);
		if (root.left == null) {
			dfs(root.right, targetSum - root.val);
			path.removeLast();
		} else if (root.right == null) {
			dfs(root.left, targetSum - root.val);
			path.removeLast();
		} else {
			dfs(root.left, targetSum - root.val);
			dfs(root.right, targetSum - root.val);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		PathSum path = new PathSum();
		TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), 
			new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), 
			new TreeNode(1))));
		root = new TreeNode(1, new TreeNode(2), null);
		System.out.println(path.pathSum(root, 1));
	}
}