import java.util.ArrayList;

class SortedListToBST {
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

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private ArrayList<Integer> array;
	public TreeNode sortedListToBST(ListNode head) {
		this.array = new ArrayList<>();
		while (head != null) {
			this.array.add(head.val);
			head = head.next;
		}
		return sort(0, array.size() - 1);
	}

	private TreeNode sort(int start, int end) {
		if (start > end) return null;
		int center = (start + end) / 2;
		TreeNode root = new TreeNode(this.array.get(center));
		root.left = sort(start, center - 1);
		root.right = sort(center + 1, end);
		return root;
	}

	private static void printHelper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return;
		if (root.left != null) System.out.print(root.left.val + " ");
		else System.out.print("#" + " ");
		if (root.right != null) System.out.print(root.right.val + " ");
		else System.out.print("#" + " ");
		printHelper(root.left);
		printHelper(root.right);
	}

	public static void main(String[] args) {
		SortedListToBST l = new SortedListToBST();
		ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
		TreeNode root = l.sortedListToBST(head);
		System.out.print(root.val + " ");
		printHelper(root);
	}
}