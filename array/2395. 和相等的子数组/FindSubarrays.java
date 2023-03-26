class FindSubarrays {
	public boolean findSubarrays(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			set.add(nums[i] + nums[i + 1]);
		}
		return set.size() != nums.length - 1;
	}
}