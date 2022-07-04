import java.util.Stack;

class ReorderList {
	static class ListNode {
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

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		ListNode middle = head, last = head, temp = null;
		while (last != null && last.next != null) {
			middle = middle.next;
			last = last.next.next;
		}

		Stack<ListNode> stack = new Stack<>();
		while (middle != null) {
			temp = middle.next;
			middle.next = null;
			stack.push(middle);
			middle = temp;
		}

		middle = head;
		while (!stack.empty()) {
			if (middle.next == null) return;
			last = middle.next;
			middle.next = stack.pop();
			if (!stack.empty()) {
				middle.next.next = last;
				middle = last;
			}
		}
	}

	public static void main(String[] args) {
		ReorderList r = new ReorderList();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		r.reorderList(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}