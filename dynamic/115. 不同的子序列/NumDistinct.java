class NumDistinct {
	public int numDistinct(String s, String t) {
		int m = s.length(), n = t.length();
		// dp[i][j] 表示为s[0-i] 和t[0-j]均闭区间的子序列个数
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) dp[i][0] = 1; // t为空，s中总存在一个
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j > i) continue;
				if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				else dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[m][n];
	}
}