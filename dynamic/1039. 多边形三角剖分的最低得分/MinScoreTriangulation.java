class MinScoreTriangulation {
	private int[][] memo;

	public int minScoreTriangulation(int[] values) {
		int n = values.length;
		memo = new int[n][n];
		for (int[] m : memo) Arrays.fill(m, -1);
		return dp(values, 0, n - 1);
	}

	private int dp(int[] values, int start, int end) {
		if (end - start == 1) return 0;
		if (memo[start][end] != -1) return memo[start][end];
		int res = Integer.MAX_VALUE;
		for (int i = start + 1; i <= end - 1; i++) {
			res = Math.min(res, dp(values, start, i) + dp(values, i, end) + values[start] * values[i] * values[end]);
		}
		memo[start][end] = res;
		return res;
	}
}