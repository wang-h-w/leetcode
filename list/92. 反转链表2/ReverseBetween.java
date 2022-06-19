class ReverseBetween {
	static class ListNode {
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

	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head.next == null) return head;
		head = new ListNode(0, head);
		ListNode curr = head;
		for (int i = 0; i < left - 1; i++) curr = curr.next;
		ListNode front = curr;
		ListNode temp = curr;
		curr = curr.next;
		for (int i = left - 1; i < right; i++) {
			if (front == temp) {
				curr = curr.next;
				temp = temp.next;
				continue;
			}
			temp.next = curr.next;
			curr.next = front.next;
			front.next = curr;
			curr = temp.next;			
		}

		return head.next;
	}

	public static void main(String[] args) {
		ReverseBetween rb = new ReverseBetween();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		head = new ListNode(5);
		ListNode result = rb.reverseBetween(head, 1,1);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}