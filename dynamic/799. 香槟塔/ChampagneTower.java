class ChampagneTower {
	public double champagneTower(int poured, int query_row, int query_glass) {
		// dp[i][j]为第i行第j列杯子所经过的水的流量（而不是最终剩余的水量）
		// 或者理解为，第一次直接把所有水都倒进了第一个杯子，如果会溢出，则继续往下分
		double[][] dp = new double[query_row + 10][query_row + 10];
		dp[0][0] = poured; // 所有的香槟都从最顶层的那个杯子倒，所经过的水量即为香槟量
		for (int i = 0; i <= query_row; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[i][j] <= 1) continue; // 不会有水从杯子溢出
				dp[i + 1][j] += (dp[i][j] - 1) / 2; // 均匀分到下面的两个杯子中
				dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
			}
		}
		return Math.min(dp[query_row][query_glass], 1);
	}
}