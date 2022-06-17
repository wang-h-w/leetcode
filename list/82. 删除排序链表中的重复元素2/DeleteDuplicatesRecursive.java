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
		// 链表问题一般都存在递归的解法，关键是要搞清楚每次递归解决的是什么问题，以及终止条件是什么
		// deleteDuplicates方法：删除以head作为头节点的有序链表中的重复值
		// 终止条件：head == null || head.next == null
		if (head == null || head.next == null) return head;
		ListNode curr = head.next;
		if (head.val == curr.val) {
			while (curr != null && head.val == curr.val) curr = curr.next;
			head = deleteDuplicates(curr);
		} else {
			head.next = deleteDuplicates(curr);
		}
		return head;
	}

	public static void main(String[] args) {
		DeleteDuplicates del = new DeleteDuplicates();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
		head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
		head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(4)))))));
		ListNode result = del.deleteDuplicates(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}