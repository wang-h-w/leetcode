class SortListRecursive {
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

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode fast = head, slow = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode sentinel = new ListNode(-1), curr = sentinel;
		while (left != null && right != null) {
			if (left.val < right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}
		curr.next = left == null ? right : left;
		return sentinel.next;
	}

	public static void main(String[] args) {
		SortListRecursive sort = new SortListRecursive();
		ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
		head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(8)))));
		// head = new ListNode(2, new ListNode(1));
		ListNode result = sort.sortList(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}