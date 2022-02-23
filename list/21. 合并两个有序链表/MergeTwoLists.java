class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) { return list2; }
		if (list2 == null) { return list1; }
		if (list1.val <= list2.val) {
			return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
		} else {
			return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
		}
    }

    public static void main(String[] args) {
        MergeTwoLists m = new MergeTwoLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(0, new ListNode(3, new ListNode(7)));
        ListNode result = m.mergeTwoLists(l1, l2);
        while (result.next != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.print(result.val);
    }
}
