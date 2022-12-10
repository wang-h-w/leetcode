class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(0), p = dummy;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		for (ListNode list : lists) if (list != null) pq.add(list);
		while (!pq.isEmpty()) {
			 ListNode curr = pq.poll();
			 p.next = curr;
			 p = p.next;
			 if (curr.next != null) pq.add(curr.next);
		}
		return dummy.next;
	}
}