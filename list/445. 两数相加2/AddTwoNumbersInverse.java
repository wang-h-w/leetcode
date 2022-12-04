class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = inverse(l1);
		l2 = inverse(l2);
		boolean carry = false;
		ListNode ret = null;
		while (l1 != null || l2 != null) {
			int sum = 0;
			if (l1 != null) { sum += l1.val; l1 = l1.next; }
			if (l2 != null) { sum += l2.val; l2 = l2.next; }
			if (carry) sum += 1;
			if (sum > 9) { carry = true; sum %= 10; }
			else carry = false;
			ret = new ListNode(sum, ret);
		}
		if (carry) ret = new ListNode(1, ret);
		return ret;
	}
	
	private ListNode inverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode inversed = inverse(head.next);
		head.next.next = head;
		head.next = null;
		return inversed;
	}
}