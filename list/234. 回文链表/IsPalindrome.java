class IsPalindrome {
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

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		// find center node (right)
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// reverse
		ListNode temp = null;
		while (slow != null) {
			ListNode next = slow.next;
			slow.next = temp;
			temp = slow;
			slow = next;
		}
		// compare
		while (temp != null && head != null) {
			if (temp.val != head.val) return false;
			temp = temp.next;
			head = head.next;
		}
		return true;
	}

	public static void main(String[] args) {
		IsPalindrome ip = new IsPalindrome();
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2))));
	}
}