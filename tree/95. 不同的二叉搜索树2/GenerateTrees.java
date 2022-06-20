import java.util.List;
import java.util.ArrayList;

class GenerateTrees {
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

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ret = new ArrayList<>();
		if (n == 0) return ret;
		return buildTree(1, n);
	}

	private List<TreeNode> buildTree(int start, int end) {
		List<TreeNode> ret = new ArrayList<>();

		if (start > end) {
			ret.add(null);
			return ret;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = buildTree(start, i - 1);
			List<TreeNode> right = buildTree(i + 1, end);
			for (TreeNode leftNode: left) {
				for (TreeNode rightNode: right) {
					ret.add(new TreeNode(i, leftNode, rightNode));
				}
			}
		}
		return ret;
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
		GenerateTrees gt = new GenerateTrees();
		List<TreeNode> result = gt.generateTrees(3);
		for (TreeNode root: result) {
			if (root != null) System.out.print(root.val + " ");
			printHelper(root);
			System.out.println();
		}
	}
}