class ReverseListRecursive {
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

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode ret = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return ret;
	}

	public static void main(String[] args) {
		ReverseListRecursive r = new ReverseListRecursive();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode res = r.reverseList(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		head = new ListNode(1, new ListNode(2));
		res = r.reverseList(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}