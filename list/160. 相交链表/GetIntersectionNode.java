class GetIntersectionNode {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
	    ListNode pA = headA, pB = headB;
	    while (pA != pB) {
	        pA = pA == null ? headB : pA.next;
	        pB = pB == null ? headA : pB.next;
	    }
	    return pA;
	}
}