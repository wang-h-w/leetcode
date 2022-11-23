import java.util.Map;
import java.util.HashMap;

class Solution {
	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	// Method 1: use HashMap which map from old Node to new Node
	// time: O(N), space: O(N)
	private Map<Node, Node> map = new HashMap<>(); // old -> new
	public Node copyRandomListHash(Node head) {
		if (head == null) return null;
		if (map.containsKey(head)) return map.get(head);
		Node copy = new Node(head.val);
		map.put(head, copy);
		copy.next = copyRandomListHash(head.next);
		copy.random = copyRandomListHash(head.random);
		return copy;
	}

	// Mothod 2: Copy new Node after old Node
	// time: O(N), space: O(1)
	public Node copyRandomListNext(Node head) {
		if (head == null) return null;
		Node curr = head;
		// copy next
		while (curr != null) {
			Node node = new Node(curr.val);
			node.next = curr.next;
			curr.next = node;
			curr = node.next;
		}
		// copy random
		curr = head;
		while (curr != null) {
			if (curr.random != null) curr.next.random = curr.random.next;
			curr = curr.next.next;
		}
		// separate
		Node ret = head.next, prev = head;
		curr = head.next;
		while (curr.next != null) {
			prev.next = prev.next.next;
			curr.next = curr.next.next;
			prev = prev.next;
			curr = curr.next;
		}
		prev.next = null;

		return ret;
	}
}