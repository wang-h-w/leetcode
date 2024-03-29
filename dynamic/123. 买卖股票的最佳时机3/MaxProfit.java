class MaxProfit {
	public int maxProfit(int[] prices) {
		int n = prices.length, maxK = 2;
		// dp[i][k][j]：在第i天最多交易k次的前提下没有持有或持有时前i天的最大收益
		int[][][] dp = new int[n][maxK + 1][2];
		for (int i = 0; i < n; i++) {
			for (int k = maxK; k >= 1; k--) {
				if (i == 0) {
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[i];
					continue;
				}
				dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
			}
		}
		return dp[n-1][maxK][0];
	}
}