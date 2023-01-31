class MergeInBetween {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        for (int i = 1; i < a; i++) {
            start = start.next;
        }
        ListNode end = start;
        for (int i = a - 2; i < b; i++) {
            end = end.next;
        }
        start.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = end;
        return list1;
    }
}