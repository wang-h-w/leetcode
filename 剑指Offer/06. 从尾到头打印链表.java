import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public int[] reversePrintStack(ListNode head) {
		Deque<Integer> stack = new LinkedList<>();
		int size = 0, index = 0;
		while (head != null) {
			stack.push(head.val);
			head = head.next;
			size++;
		}
		int[] ret = new int[size];
		while (!stack.isEmpty()) ret[index++] = stack.pop();
		return ret;
	}

	private ArrayList<Integer> temp;

	public int[] reversePrintRecursive(ListNode head) {
		temp = new ArrayList<>();
		reverseHelper(head);
		int[] ret = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) ret[i] = temp.get(i);
		return ret;
	}

	private void reverseHelper(ListNode head) {
		if (head == null) return;
		reverseHelper(head.next);
		temp.add(head.val);
	}

	public int[] reversePrint(ListNode head) {
		// count
		int cnt = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			cnt++;
		}
		// from end to start
		temp = head;
		int[] ret = new int[cnt];
		for (int i = cnt - 1; i >= 0; i--) {
			ret[i] = temp.val;
			temp = temp.next;
		}
		return ret;
	}

}