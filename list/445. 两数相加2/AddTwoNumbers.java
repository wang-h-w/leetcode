class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> d1 = new LinkedList<>(), d2 = new LinkedList<>();
		while (l1 != null) { d1.push(l1.val); l1 = l1.next; }
		while (l2 != null) { d2.push(l2.val); l2 = l2.next; }
		boolean carry = false;
		ListNode ret = null;
		while (!d1.isEmpty() || !d2.isEmpty()) {
			int sum = 0;
			if (!d1.isEmpty()) sum += d1.pop();
			if (!d2.isEmpty()) sum += d2.pop();
			if (carry) sum += 1;
			if (sum > 9) { carry = true; sum %= 10; }
			else carry = false;
			ret = new ListNode(sum, ret);
		}
		if (carry) ret = new ListNode(1, ret);
		return ret;
	}
}