class RemoveNthFromEnd_FastSlow {
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
	    dummy.next = head;
	    ListNode fast = dummy;
	    ListNode slow = dummy;

	    for (int i = 0; i <= n; i++) {
	        fast = fast.next;
	    }
	    while (fast != null) {
	        fast = fast.next;
	        slow = slow.next;
	    }
	    slow.next = slow.next.next;
	    
	    return dummy.next;
	}

	public static void main(String[] args) {
		RemoveNthFromEnd_FastSlow remove = new RemoveNthFromEnd_FastSlow();
		ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		// l = new ListNode(1, new ListNode(3));
		ListNode result = remove.removeNthFromEnd(l, 5);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}	
}