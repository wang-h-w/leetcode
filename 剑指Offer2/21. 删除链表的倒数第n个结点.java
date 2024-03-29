class Solution {
	public ListNode removeNthFromEnd(ListNode head, ListNode n) {
		ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
		dummy.next = head;
		while (n-- >= 0) fast = fast.next;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}