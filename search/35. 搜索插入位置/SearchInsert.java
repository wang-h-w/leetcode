class SearchInsert {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		int start = 0;
		int end = len - 1;
		while (start < end) {
			if (target < nums[start]) return start;
			if (target > nums[end]) return end + 1;
			int mid = (start + end) / 2;
			if (nums[mid] == target) return mid;
			else if (nums[mid] < target && target <= nums[end]) start = mid + 1;
			else end = mid - 1;
		}
		start = nums[start] < target ? start + 1 : start;
		return start;
	}

	public static void main(String[] args) {
		SearchInsert s = new SearchInsert();
		int[] nums = new int[] {1,3,5,7,9};
		System.out.println(s.searchInsert(nums, 4));
	}
}