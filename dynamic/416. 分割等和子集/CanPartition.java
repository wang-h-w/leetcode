class CanPartition {
	public boolean canPartition(int[] nums) {
		// 因为每个数都可选或不选，因此可以将问题转换为0-1背包问题
		int len = nums.length, sum = 0;
		for (int i : nums) sum += i;
		if ((sum & 1) == 1) return false;
		int target = sum / 2;

		// dp[i][j]表示表示从数组的[0,i]这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于j
		// 二维背包可以空间优化为一维
		// 在二维中，当前位置dp[i][j]的状态依赖于dp[i-1][k](k<=j)的状态，因此优化后需要从后往前遍历
		boolean[] dp = new boolean[target + 1];
		// 第一行的初始化，由于只有一个物品，因此只能当背包容量恰好等于物品容量的时候为true
		dp[0] = true;
		if (nums[0] <= target) dp[nums[0]] = true;

		for (int i = 1; i < len; i++) {
			for (int j = target; nums[i] <= j; j--) {
				if (dp[target]) return true; // 如果某一行发现已经满足要求了，直接返回（剪枝）
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		return dp[target];
	}	

	public static void main(String[] args) {
		CanPartition cp = new CanPartition();
		System.out.println(cp.canPartition(new int[] {1,5,11,5}));
		System.out.println(cp.canPartition(new int[] {1,2,3,5}));
		System.out.println(cp.canPartition(new int[] {1,2,-1,2,1,1}));
	}
}