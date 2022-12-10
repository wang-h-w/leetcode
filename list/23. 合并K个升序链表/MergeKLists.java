class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		int n = lists.length;
		ListNode dummy = new ListNode(0), p = dummy;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		for (ListNode list : lists) if (list != null) pq.add(list);
		while (!pq.isEmpty()) {
			ListNode min = pq.poll();
			p.next = min;
			p = p.next;
			if (min.next != null) pq.add(min.next);
		}
		return dummy.next;
	}
}