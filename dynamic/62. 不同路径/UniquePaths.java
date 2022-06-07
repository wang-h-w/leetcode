class UniquePaths {
	// public int uniquePaths(int m, int n) {
	// 	// 二维数组记录历史信息：(i,j)为从起始点到该位置处的路径数目
	// 	int[][] dp = new int[m][n];
	// 	int up = 0;
	// 	for (int i = 0; i < m; i++) dp[i][0] = 1;
	// 	for (int i = 0; i < n; i++) dp[0][i] = 1;
	// 	for (int i = 1; i < m; i++) {
	// 		for (int j = 1; j < n; j++) {
	// 			dp[i][j] = dp[i][j-1] + dp[i-1][j];
	// 		}
	// 	}
	// 	return dp[m-1][n-1];
	// }

	public int uniquePaths(int m, int n) {
		// 二维数组记录历史信息：(i,j)为从起始点到该位置处的路径数目
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) dp[i] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j-1];
			}
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(7,3));
	}
}