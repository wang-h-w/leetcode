class SortListIteration {
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

    public ListNode sortList(ListNode head) {
        if (head == null) return head;

        // 1. 首先从头向后遍历,统计链表长度
        int length = 0; // 用于统计链表长度
        ListNode node = head;
        while (node != null){
            length++;
            node = node.next;
        }

        // 2. 初始化引入dummynode
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 3. 每次将链表拆分成若干个长度为subLen的子链表 , 并按照每两个子链表一组进行合并
        for(int subLen = 1; subLen < length; subLen <<= 1) { // subLen每次左移一位（即sublen = sublen*2） PS:位运算对CPU来说效率更高
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next; // curr用于记录拆分链表的位置

            while(curr != null){ // 如果链表没有被拆完
                // 3.1 拆分subLen长度的链表1
                ListNode head_1 = curr; // 第一个链表的头，即curr初始的位置
                for(int i = 1; i < subLen && curr != null && curr.next != null; i++) { // 拆分出长度为subLen的链表1
                    curr = curr.next;
                }

                // 3.2 拆分subLen长度的链表2
                ListNode head_2 = curr.next; // 第二个链表的头，即链表1尾部的下一个位置
                curr.next = null; // 断开第一个链表和第二个链表的链接
                curr = head_2; // 第二个链表头 重新赋值给curr
                for(int i = 1; i < subLen && curr != null && curr.next != null; i++) { // 再拆分出长度为subLen的链表2
                    curr = curr.next;
                }

                // 3.3 再次断开第二个链表最后的next的链接
                ListNode next = null;        
                if (curr != null) {
                    next = curr.next; // next用于记录 拆分完两个链表的结束位置
                    curr.next = null; // 断开连接
                }

                // 3.4 合并两个subLen长度的有序链表
                ListNode merged = mergeTwoLists(head_1, head_2);
                prev.next = merged; // prev.next指向排好序链表的头
                while (prev.next != null) { // while循环将prev移动到subLen*2的位置后去
                    prev = prev.next;
                }
                curr = next; // next用于记录 拆分完两个链表的结束位置
            }
        }
        // 返回新排好序的链表
        return dummyHead.next;
    }


    // 此处是Leetcode21 --> 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr  = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;

        return dummy.next; 
    }

	public static void main(String[] args) {
		SortListIteration sort = new SortListIteration();
		ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
		head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(8)))));
		// head = new ListNode(2, new ListNode(1));
		ListNode result = sort.sortList(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}