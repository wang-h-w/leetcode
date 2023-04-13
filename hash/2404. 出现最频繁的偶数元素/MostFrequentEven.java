class MostFrequentEven {
	public int mostFrequentEven(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt = 0, num = -1;
		for (int x : nums) {
			if (x % 2 == 0) {
				if (!map.containsKey(x)) map.put(x, 0);
				map.put(x, map.get(x) + 1);
				if (map.get(x) > cnt) {
					cnt = map.get(x);
					num = x;
				} else if (map.get(x) == cnt) {
					if (x < num) num = x;
				}
			}
		}
		return num;
	}
}