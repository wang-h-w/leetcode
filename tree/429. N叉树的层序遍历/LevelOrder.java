import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

class LevelOrder {
	static class Node {
		public int val;
		public List<Node> children;
		
		public Node() {}
		
		public Node(int _val) {
			val = _val;
		}
		
		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
	
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> ret = new LinkedList<>();
		if (root == null) return ret;
		Deque<Node> d = new LinkedList<>();
		d.offer(root);
		while (!d.isEmpty()) {
			int num = d.size();
			List<Integer> path = new LinkedList<>();
			while (num-- > 0) {
				Node curr = d.poll();
				path.add(curr.val);
				for (Node n : curr.children) d.offer(n);
			}
			ret.add(path);
		}
		return ret;
	}
}