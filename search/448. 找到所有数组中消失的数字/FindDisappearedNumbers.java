class FindDisappearedNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			nums[idx] = -Math.abs(nums[idx]);
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) res.add(i + 1);
		}
		return res;
	}
}