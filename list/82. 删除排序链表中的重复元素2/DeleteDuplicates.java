class DeleteDuplicates {
	static class ListNode {
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

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode sentinel = new ListNode(200, head);  // -100 <= val <= 100
		int repeatValue = sentinel.val;
		ListNode last = sentinel, curr = sentinel.next;
		while (curr != null) {
			if (curr.next == null) {
				if (curr.val != repeatValue) last.next = curr;
				else last.next = null;
				break;
			}
			if (curr.val != curr.next.val && curr.val != repeatValue) {
				last.next = curr;
				last = curr;
			} else {
				repeatValue = curr.val;
			}
			curr = curr.next;
		}

		return sentinel.next;
	}

	public static void main(String[] args) {
		DeleteDuplicates del = new DeleteDuplicates();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
		head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
		head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(4)))))));
		ListNode result = del.deleteDuplicates(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}