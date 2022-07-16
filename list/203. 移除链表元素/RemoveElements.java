class RemoveElements {
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

	public ListNode removeElements(ListNode head, int val) {
		ListNode sentinel = new ListNode(0, head);
		ListNode prev = sentinel;
		while (head != null && prev != null) {
			if (head.val == val) {
				prev.next = head.next;
				head = prev.next;
				continue;
			}
			prev = prev.next;
			head = head.next;
		}

		return sentinel.next;
	}

	public static void main(String[] args) {
		RemoveElements r = new RemoveElements();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
		ListNode result = r.removeElements(head, 6);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}