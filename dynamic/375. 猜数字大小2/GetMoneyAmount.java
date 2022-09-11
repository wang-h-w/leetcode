class GetMoneyAmount {
	public int getMoneyAmount(int n) {
		// dp[i][j]表示在区间[i,j]中确保获胜的最小现金数
		int[][] dp = new int[n+2][n+2];
		for (int len = 2; len <= n; len++) { // 先计算长度小的区间，再计算大的
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1; // [i,j]之间的长度为len
				int min = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					// 在最差的情形中取最好
					// 假设当前k猜的不对，则应该惩罚金额为k的现金，左右则取更大的那个（最差情形）
					min = Math.min(min, Math.max(dp[i][k-1], dp[k+1][j]) + k);
				}
				dp[i][j] = min;
			}
		}
		return dp[1][n];
	}

	public static void main(String[] args) {
		GetMoneyAmount amount = new GetMoneyAmount();
		System.out.println(amount.getMoneyAmount(10));
	}
}