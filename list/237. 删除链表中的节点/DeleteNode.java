class DeleteNode {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}