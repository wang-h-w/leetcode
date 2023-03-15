class MaximalNetworkRank {
	public int maximalNetworkRank(int n, int[][] roads) {
		int[] memo = new int[n];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int res = Integer.MIN_VALUE;
		for (int[] road : roads) {
			memo[road[0]]++;
			memo[road[1]]++;
			int min = Math.min(road[0], road[1]), max = Math.max(road[0], road[1]);
			if (!map.containsKey(min)) map.put(min, new HashSet<>());
			map.get(min).add(max);
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (!map.containsKey(i) && map.get(i).contains(j)) res = Math.max(res, memo[i] + memo[j] - 1);
				else res = Math.max(res, memo[i] + memo[j]);
			}
		}
		return res == Integer.MIN_VALUE ? 0 : res;
	}
}