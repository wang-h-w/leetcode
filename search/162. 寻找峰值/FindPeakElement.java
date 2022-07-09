class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int len = nums.length;
		if (len == 1) return 0;
		if (len == 2) return nums[0] > nums[1] ? 0 : 1;
		int start = 0, end = len - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid > 0 && nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) return mid;
			else if (nums[mid] > nums[mid+1]) end = mid - 1;
			else if (mid > 0 && nums[mid] > nums[mid-1]) start = mid + 1;
			else start = mid + 1;
		}

		return start;
	}

	public static void main(String[] args) {
		FindPeakElement find = new FindPeakElement();
		int[] nums = new int[] {1,2,1,3,5,6,4};
		nums = new int[] {3,4,3,2,1};
		nums = new int[] {5,4,3,2,1};
		System.out.println(find.findPeakElement(nums));
	}
}