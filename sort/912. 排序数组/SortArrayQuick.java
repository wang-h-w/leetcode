class SortArray {
	public int[] sortArray(int[] nums) {
		shuffle(nums);
		sort(nums, 0, nums.length - 1);
		return nums;
	}

	private void sort(int[] nums, int l, int r) {
		if (l >= r) return;
		int p = partition(nums, l, r);
		sort(nums, l, p - 1);
		sort(nums, p + 1, r);
	}

	private int partition(int[] nums, int l, int r) {
		int pivot = nums[l], i = l + 1, j = r;
		while (i <= j) {
			while (i < r && nums[i] <= pivot) i++;
			while (j > l && nums[j] > pivot) j--;
			if (i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, l, j);
		return j;
	}

	private void shuffle(int[] nums) {
		Random random = new Random();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int r = i + random.nextInt(n - i);  // i ~ n - 1
			swap(nums, i, r);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}