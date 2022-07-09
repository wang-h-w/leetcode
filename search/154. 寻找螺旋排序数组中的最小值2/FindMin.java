class FindMin {
	public int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2; // 更偏向左侧
			if (nums[mid] > nums[end]) start = mid + 1;
			else if (nums[mid] < nums[end]) end = mid;
			else end--;
		}
		return nums[start];
	}

	public static void main(String[] args) {
		FindMin f = new FindMin();
		int[] nums = new int[] {1,2,3,4,5};
		System.out.println(f.findMin(nums));
		nums = new int[] {4,5,6,7,0,1,2};
		System.out.println(f.findMin(nums));
		nums = new int[] {11,13,15,17};
		System.out.println(f.findMin(nums));
		nums = new int[] {34};
		System.out.println(f.findMin(nums));
		nums = new int[] {13,9};
		System.out.println(f.findMin(nums));
		nums = new int[] {12,5,13};
		System.out.println(f.findMin(nums));
		nums = new int[] {19,7,12,17};
		System.out.println(f.findMin(nums));
	}
}