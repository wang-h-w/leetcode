import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Deque;

class LRUCache {
	private Deque<Integer> queue;
	private Map<Integer, Integer> map;
	private int size;

	public LRUCache(int capacity) {
		this.queue = new LinkedList<>();
		this.map = new HashMap<>();
		this.size = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		if (queue.remove(key)) queue.add(key);
		return map.get(key);
	}

	public void put(int key, int value) {
		if (!map.containsKey(key)) {
			if (size > 0) {
				queue.add(key);
				size--;
			}
			else {
				map.remove(queue.pop());
				queue.add(key);
			}
		} else {
			if (queue.remove(key)) queue.add(key);
		}
		map.put(key, value);
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