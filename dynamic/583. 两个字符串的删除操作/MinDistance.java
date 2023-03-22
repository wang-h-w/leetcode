class MinDistance {
	public int minDistance(String word1, String word2) {
		int common = longestCommonSubsequence(word1, word2);
		return word1.length() + word2.length() - 2 * common;
	}

	private int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		// dp[i][j]: s1[0~i-1] s2[0~j-1]
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		return dp[m][n];
	}
}