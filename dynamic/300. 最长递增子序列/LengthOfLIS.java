class LengthOfLIS {
	public int lengthOfLIS(int[] nums) {
		// 一维数组：当前位置为止的最长递增子序列长度
		int[] dp = new int[nums.length];
		int maxLength = 1;

		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					maxLength = Math.max(maxLength, dp[i]);
				}
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		LengthOfLIS l = new LengthOfLIS();
		System.out.println(l.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
		System.out.println(l.lengthOfLIS(new int[] {0,1,0,3,2,3}));
		System.out.println(l.lengthOfLIS(new int[] {7,7,7,7,7,7}));
		System.out.println(l.lengthOfLIS(new int[] {1,3,2,4,7,5,6}));
	}
}