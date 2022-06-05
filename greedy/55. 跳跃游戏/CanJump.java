class CanJumpSlow {
	public boolean canJump(int[] nums) {
		// 核心思想在于，对于每一个可以作为起跳点的位置，都尝试跳一次，并更新最远距离
		if (nums == null) return false;
		int k = 0;
		for (int i = 0; i <= k; i++) {
			int temp = i + nums[i]; // 第i个元素能到的最远距离
			k = Math.max(k, temp); // 更新最远距离
			if (k >= nums.length - 1) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CanJumpSlow jump = new CanJumpSlow();
		int[] nums = new int[] {2,3,1,1,4};
		nums = new int[] {3,2,1,0,4};
		nums = new int[] {2,0,0};
		System.out.println(jump.canJump(nums));
	}
}