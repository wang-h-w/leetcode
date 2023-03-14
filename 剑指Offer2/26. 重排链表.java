class Solution {
	public void reorderList(ListNode head) {
		ListNode slow = head, fast = head, temp = null;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = reverse(slow);
		slow = head;
		while (slow != null && fast != null && slow != fast) {
			temp = slow.next;
			slow.next = fast;
			fast = fast.next;
			if (slow.next != temp) slow.next.next = temp;
            slow = slow.next.next;
		}
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode ret = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return ret;
	}
}