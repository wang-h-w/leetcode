class FindMin {
	public int findMin(int[] nums) {
		return find(nums, 0, nums.length - 1);
	}

	private int find(int[] nums, int start, int end) {
		if (start == end) return nums[start];
		int mid = (start + end) / 2;
		if (nums[mid] < nums[start]) {
			if (mid == start + 1 || nums[mid-1] > nums[mid]) return nums[mid];
			return find(nums, start, mid - 1);
		} else if (nums[mid] > nums[end]) {
			if (mid == end - 1) return nums[end];
			return find(nums, mid + 1, end);
		} else {
			return nums[start];
		}
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