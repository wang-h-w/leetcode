class LargestSumOfAverages {
	public double largestSumOfAverages(int[] nums, int K) {
		int n = nums.length;
		double[] sum = new double[n + 1];
		double[][] dp = new double[n + 1][K + 1]; // dp[i][j]前i个数分为j组后的最大平均值
		for (int i = 1; i <= n; i++) {
			sum[i] += sum[i-1] + nums[i-1];
			dp[i][1] = sum[i] / i;
		}
		for (int i = 1; i <= n; i++) {
			for (int k = 2; k <= K; k++) {
				// 枚举最后一个子数组的起点
				for (int j = 0; j < i; j++) dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (sum[i] - sum[j]) / (i - j));
			}
		}
		return dp[n][K];
	}

	public static void main(String[] args) {
		LargestSumOfAverages lsa = new LargestSumOfAverages();
		System.out.println(lsa.largestSumOfAverages(new int[] {9,1,2,3,9}, 3));
		System.out.println(lsa.largestSumOfAverages(new int[] {1,2,3,4,5,6,7}, 4));
	}
}