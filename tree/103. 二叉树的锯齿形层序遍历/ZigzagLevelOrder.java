import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class ZigzagLevelOrder {
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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<>();
		LinkedList<Integer> level = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		int levelSize = 1;
		boolean fromLeft = true;
		if (root == null) return ret;
		queue.offer(root);
		
		while (queue.size() != 0) {
			TreeNode node = queue.poll();
			if (node.left != null) queue.offer(node.left);
			if (node.right != null) queue.offer(node.right);
			if (fromLeft) level.addLast(node.val);
			else level.addFirst(node.val);
			levelSize--;

			if (levelSize == 0) {
				ret.add(new LinkedList<>(level));
				level.clear();
				levelSize = queue.size();
				fromLeft = !fromLeft;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		ZigzagLevelOrder z = new ZigzagLevelOrder();
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(z.zigzagLevelOrder(root));
	}
}