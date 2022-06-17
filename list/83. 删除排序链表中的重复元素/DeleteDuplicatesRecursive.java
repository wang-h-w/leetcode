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
		// 每次返回的都是已经去重的链表的头
		if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) head = head.next;
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