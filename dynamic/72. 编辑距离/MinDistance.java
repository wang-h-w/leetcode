class MinDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		// dp[i][j]: word1[0~i-1]与word2[0~j-1]的最小编辑距离
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) dp[i][0] = i;
		for (int j = 1; j <= n; j++) dp[0][j] = j;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
				else dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
			}
		}
		return dp[m][n];
	}

	private int min(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}
}