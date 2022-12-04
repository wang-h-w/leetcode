class FindDuplicates {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new LinkedList<>();
		for (int x : nums) {
			int index = Math.abs(x) - 1;
			if (nums[index] < 0) list.add(index + 1);
			nums[index] = -nums[index];
		}
		return list;
	}
}