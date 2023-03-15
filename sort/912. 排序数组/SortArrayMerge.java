class SortArray {
	private int[] temp;

	public int[] sortArray(int[] nums) {
		temp = new int[nums.length];
		sort(nums, 0, nums.length - 1);
		return nums;
	}

	private void sort(int[] nums, int l, int r) {
		if (l == r) return;
		int mid = l + (r - l) / 2;
		sort(nums, l, mid);
		sort(nums, mid + 1, r);
		merge(nums, l, mid, r);
	}

	private void merge(int[] nums, int l, int mid, int r) {
		for (int i = l; i <= r; i++) temp[i] = nums[i]; // copy to temp array
		int p1 = l, p2 = mid + 1;
		for (int i = l; i <= r; i++) {
			if (p1 == mid + 1) nums[i] = temp[p2++];
			else if (p2 == r + 1) nums[i] = temp[p1++];
			else if (temp[p1] <= temp[p2]) nums[i] = temp[p1++];
			else if (temp[p1] > temp[p2]) nums[i] = temp[p2++];
		}
	}
}