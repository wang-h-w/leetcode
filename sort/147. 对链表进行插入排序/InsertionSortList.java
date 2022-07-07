class InsertionSortList {
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

	public ListNode insertionSortList(ListNode head) {
		if (head == null) return null;
		head = new ListNode(0, head); // sentinel
		ListNode iter = head.next.next, prev = head.next;
		while (iter != null) {
			if (iter.val >= prev.val) {
				iter = iter.next;
				prev = prev.next;
				continue;
			}
			
			ListNode move_prev = head;
			ListNode move_curr = head.next;
			// remove
			ListNode temp = iter;
			iter = iter.next;
			prev.next = iter;
			// find position
			while (move_curr.val <= temp.val) {
				move_curr = move_curr.next;
				move_prev = move_prev.next;
			}
			temp.next = move_curr;
			move_prev.next = temp;
		}

		return head.next;
	}

	public static void main(String[] args) {
		InsertionSortList sort = new InsertionSortList();
		ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
		head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(3)))));
		head = new ListNode(2, new ListNode(1));
		ListNode result = sort.insertionSortList(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}