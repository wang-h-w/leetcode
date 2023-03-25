class SuperEggDrop {
	public int superEggDrop(int K, int N) {
		int[][] dp = new int[K + 1][N + 1];
		int m = 0;
		while (dp[K][m] < N) {
			m++;
			for (int k = 1; k <= K; k++) {
				dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
			}
		}
		return m;
	}
}