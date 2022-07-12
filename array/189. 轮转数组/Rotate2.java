class Rotate2 {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		int[] temp = new int[k];
		for (int i = len - k; i < len; i++) temp[i - len + k] = nums[i];
		System.arraycopy(nums, 0, nums, k, len - k);
		System.arraycopy(temp, 0, nums, 0, k);
	}

	public static void main(String[] args) {
		Rotate2 r = new Rotate2();
		int[] nums = new int[] {1,2,3,4,5,6,7};
		r.rotate(nums, 3);
		for (int i: nums) System.out.print(i + " ");
		System.out.println();
		nums = new int[] {-1,-100,3,99};
		r.rotate(nums, 2);
		for (int i: nums) System.out.print(i + " ");
	}
}