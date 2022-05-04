class AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {};
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		add(l1, l2, result);
		return result;
	}

	private void add(ListNode l1, ListNode l2, ListNode result) {
		int carry = result.val + (l1.val + l2.val) % 10;
		result.val = carry < 10 ? carry : 0;
		if (l1.next == null && l2.next == null) {
			if ((l1.val + l2.val + carry / 10) / 10 == 1) {
				result.next = new ListNode(1);
			}
			return;
		}

		result.next = new ListNode((l1.val + l2.val + carry / 10) / 10);
		if (l1.next == null) {
			add(new ListNode(0), l2.next, result.next);
		} else if (l2.next == null) {
			add(l1.next, new ListNode(0), result.next);
		} else {
			add(l1.next, l2.next, result.next);
		}
	}

	public static void main(String[] args) {
		AddTwoNumbers add = new AddTwoNumbers();
		ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(9, new ListNode(9))));
		ListNode l2 = new ListNode(9, new ListNode(8));
		ListNode result = add.addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}