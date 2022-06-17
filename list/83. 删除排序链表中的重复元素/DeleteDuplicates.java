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
		ListNode last = head;
		ListNode curr = head.next;
		while (curr != null) {
			if (curr.val != last.val) {
				last.next = curr;
				last = curr;
				curr = curr.next;
			} else {
				if (curr.next == null) last.next = null;
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		DeleteDuplicates del = new DeleteDuplicates();
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
		head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
		ListNode result = del.deleteDuplicates(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}