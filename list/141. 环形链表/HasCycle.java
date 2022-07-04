class HasCycle {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		HasCycle has = new HasCycle();
		ListNode head = new ListNode(3);
		ListNode curr = head;
		curr.next = new ListNode(2);
		curr = curr.next;
		ListNode pos = curr;
		curr.next = new ListNode(0);
		curr = curr.next;
		curr.next = new ListNode(-4);
		curr = curr.next;
		curr.next = pos;

		System.out.println(has.hasCycle(head));
	}
}