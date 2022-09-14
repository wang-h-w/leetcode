import java.util.List;
import java.util.ArrayList;

class Solution {
	List<Integer> list;
	Random random;

	public Solution(ListNode head) {
		list = new ArrayList<>();
		random = new Random();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
	}

	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}

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
}