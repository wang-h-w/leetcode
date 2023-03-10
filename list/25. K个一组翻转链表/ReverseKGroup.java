class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) return null;
		ListNode a = head, b = head;
		for (int i = 0; i < k; i++) {
			if (b == null) return head;
			b = b.next;
		}
		ListNode newHead = reverse(a, b);
		a.next = reverseKGroup(b, k);
		return newHead;
	}

	private ListNode reverse(ListNode a, ListNode b) {
		ListNode prev = null, curr = a, temp = a;
		while (curr != b) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
}