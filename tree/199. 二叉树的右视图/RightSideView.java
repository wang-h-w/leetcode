import java.util.List;
import java.util.LinkedList;
import java.util.Deque;

class RightSideView {
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

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		if (root == null) return ret;
		deque.add(root);
		int cnt = 1;

		while (deque.size() != 0) {
			TreeNode node = deque.poll();
			if (node.left != null) deque.add(node.left);
			if (node.right != null) deque.add(node.right);
			cnt--;

			if (cnt == 0) {
				ret.add(node.val);
				cnt = deque.size();
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		RightSideView right = new RightSideView();
		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
		root = new TreeNode(24, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
		System.out.println(right.rightSideView(root));
	}
}