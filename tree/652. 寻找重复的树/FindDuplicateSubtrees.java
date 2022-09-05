import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class FindDuplicateSubtrees {
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

	private List<TreeNode> ans = new LinkedList<>();
	private Map<String, Integer> map = new HashMap<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		dfs(root);
		return ans;
	}

	private String dfs(TreeNode node) {
		if (node == null) return "";
		String ss = node.val + " " + dfs(node.left) + " " + dfs(node.right);
		if (!map.containsKey(ss)) map.put(ss, 1);
		else map.put(ss, map.get(ss) + 1);
		if (map.get(ss) == 2) ans.add(node);
		return ss;
	}

	public static void main(String[] args) {
		FindDuplicateSubtrees find = new FindDuplicateSubtrees();
		System.out.println(find.findDuplicateSubtrees(new TreeNode(2, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null))));
	}
}