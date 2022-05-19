class RemoveNthFromEnd_return {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		return removeNode(head, n) == n ? head.next : head;
	}

	public int removeNode(ListNode node, int n) {		
		if (node.next == null)  return 1;
		int m = removeNode(node.next, n);
		if (m == n) 
			if (m == 1) node.next = null;
			else node.next = node.next.next;
		return m + 1;
	}

	public static void main(String[] args) {
		RemoveNthFromEnd_return remove = new RemoveNthFromEnd_return();
		ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		// l = new ListNode(1, new ListNode(3));
		ListNode result = remove.removeNthFromEnd(l, 5);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}	
}