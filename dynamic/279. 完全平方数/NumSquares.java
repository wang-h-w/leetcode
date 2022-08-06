class NumSquares {
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			dp[i] = i;
			for (int j = 1; i - j * j >= 0; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		NumSquares ns = new NumSquares();
		System.out.println(ns.numSquares(12));
		System.out.println(ns.numSquares(13));
	}
}