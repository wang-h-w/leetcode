class MinFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) dp[i] = matrix[0][i];
		for (int row = 1; row < n; row++) {
			int temp = dp[0];
			for (int col = 0; col < n; col++) {
				int sum = Math.min(Math.min(dp[col], col == n - 1 ? dp[col] : dp[col + 1]), temp) + matrix[row][col];
				temp = dp[col];
				dp[col] = sum;
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) res = Math.min(res, dp[i]);
		return res;
	}
}