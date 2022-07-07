import java.util.Map;
import java.util.HashMap;

class LRUCache {
	class ListNode {
		int key, value;
		ListNode prev, next;
		public ListNode(int k, int v) {
			this.key = k;
			this.value = v;
		}
	}

	class DoubleLinkedList {
		private ListNode head, tail;
		private int size;

		public DoubleLinkedList() {
			this.head = new ListNode(0, 0);
			this.tail = new ListNode(0, 0);
			this.size = 0;
			head.next = tail;
			tail.prev = head;
		}

		public void addLast(ListNode n) {
			n.prev = tail.prev;
			n.next = tail;
			tail.prev.next = n;
			tail.prev = n;
			size++;
		}

		public void remove(ListNode n) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
			size--;
		}

		public ListNode removeFirst() {
			if (size == 0) return null;
			ListNode first = head.next;
			remove(first);
			return first;
		}

		public int size() {
			return size;
		}
	}

	private Map<Integer, ListNode> map;
	private DoubleLinkedList queue;
	private int capacity;

	public LRUCache(int capacity) {
		this.map = new HashMap<>();
		this.queue = new DoubleLinkedList();
		this.capacity = capacity;
	}

	private void deleteKey(int key) {
		ListNode n = map.get(key);
		queue.remove(n);
		map.remove(key);
	}

	private void addRecently(int key, int val) {
		ListNode n = new ListNode(key, val);
		queue.addLast(n);
		map.put(key, n);
	}

	private void removeLeastRecently() {
		ListNode n = queue.removeFirst();
		map.remove(n.key);
	}

	private void makeRecently(int key) {
		ListNode n = map.get(key);
		queue.remove(n);
		queue.addLast(n);
	}

	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		makeRecently(key);
		return map.get(key).value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			deleteKey(key);
			addRecently(key, value);
			return;
		}
		if (capacity == queue.size()) {
			removeLeastRecently();
		}
		addRecently(key, value);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.print(cache.get(1) + " ");
		cache.put(3, 3);
		System.out.print(cache.get(2) + " ");
		cache.put(4, 4);
		System.out.print(cache.get(1) + " ");
		System.out.print(cache.get(3) + " ");
		System.out.print(cache.get(4) + " ");
	}
}