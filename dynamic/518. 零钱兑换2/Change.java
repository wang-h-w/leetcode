class Change {
	public int change(int amount, int[] coins) {
		int n = coins.length;
		// 若只使用前 i 个物品（可以重复使用），当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包。
		int[][] dp = new int[n + 1][amount + 1];
		for (int i = 0; i <= n; i++) dp[i][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j < coins[i - 1]) dp[i][j] = dp[i - 1][j];
				else dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
			}
		}
		return dp[n][amount];
	}
}