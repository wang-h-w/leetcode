class IntegerBreak {
	public int integerBreak(int n) {
		// dp[i]表示将正整数i拆分后最大的乘积
		int[] dp = new int[n+1];
		for (int i = 2; i <= n; i++) {
			int currMax = 0;
			// 要么拆分为两个（至少），要么拆分为多个（取决于之前dp的计算结果）
			for (int j = 1; j < i; j++) currMax = Math.max(currMax, Math.max(j*(i-j), j*dp[i-j]));
			dp[i] = currMax;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		IntegerBreak ib = new IntegerBreak();
		System.out.println(ib.integerBreak(2));
		System.out.println(ib.integerBreak(10));
	}
}