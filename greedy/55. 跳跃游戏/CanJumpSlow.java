class CanJumpSlow {
	public boolean canJump(int[] nums) {
		// 一维数组记录历史信息：是否能抵达该位置
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		for (int i = 1; i < nums.length; i++) {
			for (int back = i - 1; back >= 0; back--) {
				if (dp[back] && back + nums[back] >= i) dp[i] = true;
			}
		}
		return dp[nums.length - 1];
	}

	public static void main(String[] args) {
		CanJumpSlow jump = new CanJumpSlow();
		int[] nums = new int[] {2,3,1,1,4};
		nums = new int[] {3,2,1,0,4};
		nums = new int[] {2,0,0};
		System.out.println(jump.canJump(nums));
	}
}