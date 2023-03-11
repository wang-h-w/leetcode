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

	private ListNode left;

	public boolean isPalindrome(ListNode head) {
		// 利用二叉树的后序遍历（相当于反打印链表）
		left = head;
		return traverse(head);
	}

	private boolean traverse(ListNode right) {
		if (right == null) return true;
		boolean res = traverse(right.next);
		res = res && (right.val == left.val);
		left = left.next;
		return res;
	}

	public static void main(String[] args) {
		IsPalindrome ip = new IsPalindrome();
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
		System.out.println(ip.isPalindrome(new ListNode(1, new ListNode(2))));
	}
}