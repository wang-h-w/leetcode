import java.util.Map;
import java.util.HashMap;

class TotalFruit {
	public int totalFruit(int[] fruits) {
		Map<Integer, Integer> map = new HashMap<>();
		int start = 0, end = 0, max = Integer.MIN_VALUE;
		while (end < fruits.length) {
			int curr = fruits[end++];
			if (!map.containsKey(curr)) map.put(curr, 0);
			map.put(curr, map.get(curr) + 1);
			if (map.size() > 2) {
				int prev = fruits[start++];
				map.put(prev, map.get(prev) - 1);
				if (map.get(prev) == 0) map.remove(prev);
			}
			max = Math.max(max, end - start);
		}
		return max;
	}

	public static void main(String[] args) {
		TotalFruit fruit = new TotalFruit();
		System.out.println(fruit.totalFruit(new int[] {1,2,1}));
		System.out.println(fruit.totalFruit(new int[] {0,1,2,2}));
		System.out.println(fruit.totalFruit(new int[] {1,2,3,2,2}));
		System.out.println(fruit.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
		System.out.println(fruit.totalFruit(new int[] {1,2,3,4,5,6,7}));
	}
}