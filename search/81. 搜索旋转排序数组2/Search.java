class Search {
	public boolean search(int[] nums, int target) {
		int front = 0;
		int end = nums.length - 1;
		while (front <= end) {
			if (nums[front] == target || nums[end] == target) return true;
			if (nums[front] == nums[end]) {
				front++;
				end--;
				continue;
			}
			int center = (front + end) / 2;
			if (nums[center] == target) return true;
			if (nums[center] <= nums[end]) {
				// 右边是有序的
				if (nums[center] < target && target <= nums[end]) front = center + 1;
				else end = center - 1;
			} else {
				// 左边是有序的
				if (nums[front] <= target && target < nums[center]) end = center - 1;
				else front = center + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Search s = new Search();
		int[] nums = new int[] {2,5,6,0,0,1,2};
		// nums = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		System.out.println(s.search(nums, 3));
	}
}