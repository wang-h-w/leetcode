class ReverseList {
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
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		ReverseList r = new ReverseList();
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