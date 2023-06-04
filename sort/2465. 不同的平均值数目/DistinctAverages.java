class DistinctAverages {
	public int distinctAverages(int[] nums) {
		Arrays.sort(nums);
		Set<Double> set = new HashSet<>();
		for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
			set.add(1.0 * (nums[i] + nums[j]) / 2);
		}
		return set.size();
	}
}