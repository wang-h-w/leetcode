import java.util.Arrays;

class CoinChange {
	public int coinChange(int[] coins, int amount) {
		// dp[i][j]表示，用前i种硬币凑成j所需的最少数量
		if (amount == 0) return 0;
		int m = coins.length;
		int[][] dp = new int[m+1][amount+1];
		for (int i = 0; i < m + 1; i++) Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < amount + 1; j++) {
				dp[i][j] = dp[i-1][j];
				if (j % coins[i-1] == 0) dp[i][j] = Math.min(dp[i][j], j / coins[i-1]);
				if (j >= coins[i-1]) {
					dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1));
				}
			}
		}
		return dp[m][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[m][amount];
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(new int[] {1,2,5}, 11));
		System.out.println(cc.coinChange(new int[] {2}, 3));
		System.out.println(cc.coinChange(new int[] {1}, 0));
	}
}