class MinSwap {
	// public int minSwap(int[] nums1, int[] nums2) {
	// 	// dp[i][0]表示i位置不交换时，使序列递增的最小交换次数
	// 	// dp[i][1]表示i位置交换时，使序列递增的最小交换次数
	// 	int n = nums1.length;
	// 	int[][] dp = new int[n][2];
	// 	dp[0][0] = 0;
	// 	dp[0][1] = 1;

	// 	for (int i = 1; i < n; i++) {
	// 		int currA = nums1[i], prevA = nums1[i-1], currB = nums2[i], prevB = nums2[i-1];
	// 		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
	// 		// 当前不交换
	// 		if (currA > prevA && currB > prevB) a = Math.min(a, dp[i-1][0]);
	// 		if (currA > prevB && currB > prevA) a = Math.min(a, dp[i-1][1]);
	// 		dp[i][0] = a;
	// 		// 当前交换
	// 		if (currB > prevA && currA > prevB) b = Math.min(b, dp[i-1][0] + 1);
	// 		else if (currB > prevB && currA > prevA) b = Math.min(b, dp[i-1][1] + 1);
	// 		dp[i][1] = b;
	// 	}
	// 	return Math.min(dp[n-1][0], dp[n-1][1]);
	// }

	public int minSwap(int[] nums1, int[] nums2) {
		// dp[i][0]表示i位置不交换时，使序列递增的最小交换次数
		// dp[i][1]表示i位置交换时，使序列递增的最小交换次数
		int n = nums1.length;
		int[] dp = new int[] {0, 1};

		for (int i = 1; i < n; i++) {
			int currA = nums1[i], prevA = nums1[i-1], currB = nums2[i], prevB = nums2[i-1];
			int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
			// 当前不交换
			if (currA > prevA && currB > prevB) a = Math.min(a, dp[0]);
			if (currA > prevB && currB > prevA) a = Math.min(a, dp[1]);
			// 当前交换
			if (currB > prevA && currA > prevB) b = Math.min(b, dp[0] + 1);
			if (currB > prevB && currA > prevA) b = Math.min(b, dp[1] + 1);
			// 更新
			dp[0] = a;
			dp[1] = b;
		}
		return Math.min(dp[0], dp[1]);
	}

	public static void main(String[] args) {
		MinSwap ms = new MinSwap();
		System.out.println(ms.minSwap(new int[] {1,3,5,4}, new int[] {1,2,3,7}));
		System.out.println(ms.minSwap(new int[] {0,3,5,8,9}, new int[] {2,1,4,6,9}));
	}
}