import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

class TopKFrequent {
	public int[] topKFrequent(int[] nums, int k) {
		int[] ret = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return map.get(a) - map.get(b);
			}
		});
		
		for (int i : nums) {
			if (map.containsKey(i)) map.put(i, map.get(i) + 1);
			else map.put(i, 1);
		}
		
		for (int i : map.keySet()) {
			if (pq.size() < k) pq.add(i);
			else if (map.get(i) > map.get(pq.peek())) {
				pq.remove();
				pq.add(i);
			}
		}
		
		for (int i = 0; i < k; i++) ret[i] = pq.remove();
		
		return ret;
	}
}