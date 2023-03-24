class FindCheapestPrice {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		// dp[i][j]：从出发点到j节点中转i次的最低价格
		int MAX = 10000 * 101 + 1;
		int[][] dp = new int[k + 1][n];
		for (int i = 0; i < k + 1; i++) Arrays.fill(dp[i], MAX);
		for (int[] flight : flights) {
			int from = flight[0], to = flight[1], cost = flight[2];
			if (src == from) dp[0][to] = cost;
		}
		for (int i = 1; i < k + 1; i++) {
			for (int[] flight : flights) {
				int from = flight[0], to = flight[1], cost = flight[2];
				dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
			}
		}
		int res = MAX;
		for (int i = 0; i < k + 1; i++) res = Math.min(res, dp[i][dst]);
		return res == MAX ? -1 : res;
	}
}