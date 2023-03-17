class AnswerQueries {
	public int[] answerQueries(int[] nums, int[] queries) {
		int[] preSum = new int[nums.length + 1];
		Arrays.sort(nums);
		for (int i = 1; i <= nums.length; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
		for (int i = 0; i < queries.length; i++) {
			int target = queries[i];
			queries[i] = search(preSum, target);
		}
		return queries;
	}

	private int search(int[] nums, int target) {
		int l = 0, r = nums.length;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] <= target) l = mid + 1;
			else r = mid;
		}
		return l - 1;
	}
}