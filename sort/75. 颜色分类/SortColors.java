class SortColors {
	public void sortColors(int[] nums) {
		int start = 0, end = nums.length - 1, curr = 0;
		while (curr <= end) {
			if (nums[curr] == 0) {
				int temp = nums[start];
				nums[start] = nums[curr];
				nums[curr] = temp;
				start++;
				if (curr < start) curr++;
			} else if (nums[curr] == 2) {
				int temp = nums[end];
				nums[end] = nums[curr];
				nums[curr] = temp;
				end--;
			} else {
				curr++;
			}
		}
	}

	public static void main(String[] args) {
		SortColors sort = new SortColors();
		int[] nums = new int[] {2,0,2,1,1,0};
		nums = new int[] {0,0,1,0,1,0};
		nums = new int[] {2,0,1};
		sort.sortColors(nums);
		for (int i: nums) System.out.print(i + " ");
	}
}