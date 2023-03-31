class TriangleNumber {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length, res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i - 1, k = 0; k < j; j--) {
				while (k < j && nums[k] + nums[j] <= nums[i]) k++;
				res += j - k;
			}
		}
		return res;
	}
}