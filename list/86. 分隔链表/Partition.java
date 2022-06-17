class Partition {
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

	public ListNode partition(ListNode head, int x) {
		ListNode before = new ListNode(0);
		ListNode after = new ListNode(0);
		ListNode beforePointer = before;
		ListNode afterPointer = after;
		while (head != null) {
			if (head.val < x) {
				beforePointer.next = head;
				head = head.next;
				beforePointer = beforePointer.next;
				beforePointer.next = null;
			} else {
				afterPointer.next = head;
				head = head.next;
				afterPointer = afterPointer.next;
				afterPointer.next = null;
			}
		}
		beforePointer.next = after.next;

		return before.next;
	}

	public static void main(String[] args) {
		Partition p = new Partition();
		ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
		head = new ListNode(2, new ListNode(1));
		ListNode result = p.partition(head, 2);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}