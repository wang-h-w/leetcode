class OddEvenList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {};
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null) return null;
		ListNode odd = new ListNode(0), even = new ListNode(0);
		ListNode moveOdd = odd, moveEven = even;
		boolean isOdd = true;

		while (head != null) {
			if (isOdd) {
				moveOdd.next = head;
				moveOdd = moveOdd.next;
				head = head.next;
				moveOdd.next = null;
			} else {
				moveEven.next = head;
				moveEven = moveEven.next;
				head = head.next;
				moveEven.next = null;
			}
			isOdd = !isOdd;
		}

		moveOdd.next = even.next;
		return odd.next;
	}

	public static void main(String[] args) {
		OddEvenList o = new OddEvenList();

		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode res = o.oddEvenList(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();

		head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		res = o.oddEvenList(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();

		head = new ListNode(1);
		res = o.oddEvenList(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();
	}
}