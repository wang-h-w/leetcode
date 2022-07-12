class Rotate1 {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		reverse(nums, 0, len - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, len - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

	public static void main(String[] args) {
		Rotate1 r = new Rotate1();
		int[] nums = new int[] {1,2,3,4,5,6,7};
		r.rotate(nums, 3);
		for (int i: nums) System.out.print(i + " ");
		System.out.println();
		nums = new int[] {-1,-100,3,99};
		r.rotate(nums, 2);
		for (int i: nums) System.out.print(i + " ");
	}
}