import java.util.Set;
import java.util.HashSet;

class NumComponents {
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

	public int numComponents(ListNode head, int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) set.add(n);
		int cnt = 0;
		boolean prev = false;
		while (head != null) {
			if (set.contains(head.val)) {
				if (!prev) cnt++;
				prev = true;
			} else {
				prev = false;
			}
			head = head.next;
		}
		return cnt;
	}
}