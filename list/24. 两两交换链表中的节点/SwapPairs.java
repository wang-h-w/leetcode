class SwapPairs {
	public static class ListNode {
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

	public ListNode swapPairs(ListNode head) {
		head = swap(head);
		return head;
	}

	private ListNode swap(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode temp = head;
		head = head.next;
		temp.next = head.next;
		head.next = temp;
		temp.next = swap(temp.next);
		return head;
	}

	public static void main(String[] args) {
		SwapPairs sp = new SwapPairs();
		ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		ListNode result = sp.swapPairs(node);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}