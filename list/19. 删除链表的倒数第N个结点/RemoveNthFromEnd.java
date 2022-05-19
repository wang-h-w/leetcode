class RemoveNthFromEnd {
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
		ListNode[] loc = new ListNode[31];
		ListNode curr = head;
		int len = 0;
		while (curr != null) {
			loc[len] = curr;
			curr = curr.next;
			len++;
		}
		if (len - n - 1 < 0) {
			head = head.next;
		} else {
			loc[len - n - 1].next = loc[len - n + 1];
		}
		
		return head;
	}

	public static void main(String[] args) {
		RemoveNthFromEnd remove = new RemoveNthFromEnd();
		ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		// l = new ListNode(1, new ListNode(3));
		ListNode result = remove.removeNthFromEnd(l, 5);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}	
}