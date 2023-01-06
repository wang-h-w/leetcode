class Search {
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length;
		int mid = 0;
		while (l < r) {
			mid = l + (r - l) / 2;
			if (nums[mid] == target) return mid;
			else if (nums[mid] < target) l = mid + 1;
			else r = mid;
		}
		return nums[mid] == target ? mid : -1;
	}
}