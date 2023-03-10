class ReverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode reversed = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
	}

	public ListNode reverseListIter(ListNode head) {
		ListNode pre = null, curr = head;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
		return pre;
	}
}