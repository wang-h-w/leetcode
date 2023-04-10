class NextLargerNodes {
	public int[] nextLargerNodes(ListNode head) {
		Deque<Integer> stack = new LinkedList<>(), idx = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		ListNode curr = head;
		int size = 0;
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		int[] res = new int[size];

		int p = 0;
		while (head != null) {
			while (!stack.isEmpty() && stack.peekLast() < head.val) {
				stack.pollLast();
				res[idx.pollLast()] = head.val;
			}
			stack.addLast(head.val);
			idx.addLast(p++);
			head = head.next;
		}
		return res;
	}
}