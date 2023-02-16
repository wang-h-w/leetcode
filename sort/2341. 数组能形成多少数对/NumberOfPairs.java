class NumberOfPairs {
	public int[] numberOfPairs(int[] nums) {
		int[] res = new int[2];
		Arrays.sort(nums);
		int memo = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				if (memo % 2 != 0) res[1]++;
				memo = 1;
				continue;
			}
			memo++;
		}
		if (memo % 2 != 0) res[1]++;
		res[0] = (nums.length - res[1]) / 2;
		return res;
	}
}