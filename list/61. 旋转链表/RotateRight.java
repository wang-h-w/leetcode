class RotateRight {
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

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) return head;
		ListNode front = head;
		int index = 0;
		while (index < k && head.next != null) {
			index++;
			head = head.next;
		}
		ListNode end = head;
		head = front;
		int size = index + 1;
		while (end.next != null) {
			head = head.next;
			end = end.next;
			size++;
		}
		if (k % size == 0) return front;
		if (k > size) for (int i = 0; i < size - k % size - 1; i++) head = head.next;
		end.next = front;
		front = head.next;
		head.next = null;
		return front;
	}

	public static void main(String[] args) {
		RotateRight rotate = new RotateRight();
		ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		l = new ListNode(0, new ListNode(1, new ListNode(2)));
		l = new ListNode(1);
		ListNode result = rotate.rotateRight(l, 4);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}