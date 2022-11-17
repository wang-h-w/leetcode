class Solution {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode reverseListRecursive(ListNode head) {
		/**
		 * 1 -> 2 -> 3 -> 4 -> 5 -> null
		 * 1 -> 2 <- 3 <- 4 <- 5
		 *      | -> null
		**/
		if (head == null || head.next == null) return head;
		ListNode reversed = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
	}

	public ListNode reverseListIterative(ListNode head) {
		ListNode curr = head, prev = null;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
}