class MinSideJumps {
	public int minSideJumps(int[] obstacles) {
		int n = obstacles.length;
		int[][] dp = new int[n][3]; // 到达第i个点且处于第j条跑道时的最小侧跳次数
		dp[0][0] = 1; dp[0][1] = 0; dp[0][2] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (obstacles[i] == j + 1) dp[i][j] = Integer.MAX_VALUE;
				else dp[i][j] = dp[i-1][j];
			}
			for (int j = 0; j < 3; j++) {
				if (obstacles[i] == j + 1) continue;
				dp[i][j] = Math.min(dp[i][j], Math.min(Math.min(dp[i][0], dp[i][1]), dp[i][2]) + 1);
			}
		}
		return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
	}
}