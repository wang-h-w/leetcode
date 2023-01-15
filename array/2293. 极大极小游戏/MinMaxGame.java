class MinMaxGame {
	public int minMaxGame(int[] nums) {
		while (nums.length != 1) {
			int[] temp = new int[nums.length / 2];
			for (int i = 0; i < nums.length / 2; i++) {
				if (i % 2 == 0) temp[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
				else temp[i] = temp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
			}
			nums = temp;
		}
		return nums[0];
	}
}