class MaxProfit {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		// dp[i][j]：第i天没有持有或持有时，前i天的最大收益
		int[][] dp = new int[n][2];
		dp[0][0] = 0; dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], -prices[i]); // 只允许交易一次，所以是相反数
		}
		return dp[n-1][0];
	}
}