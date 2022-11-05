class Flatten {
	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	}
	
	private Node last;
	
	public Node flatten(Node head) {
		Node curr = head;
		while (curr != null) {
			if (curr.child == null) {
				last = curr;
				curr = curr.next;
				continue;
			}
			Node childNodes = flatten(curr.child);
			Node currNext = curr.next;
			curr.next = childNodes;
			childNodes.prev = curr;
			curr.child = null;
			last.next = currNext;
			if (currNext != null) currNext.prev = last;
			curr = currNext;
		}
		return head;
	}
}