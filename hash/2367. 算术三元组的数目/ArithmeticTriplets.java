class ArithmeticTriplets {
	public int arithmeticTriplets(int[] nums, int diff) {
		Set<Integer> set = new HashSet<>();
		for (int x : nums) set.add(x);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i] + diff) && set.contains(nums[i] + 2 * diff)) res++;
		}
		return res;
	}
}