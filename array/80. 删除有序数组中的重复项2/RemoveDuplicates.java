class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 1 || nums.length == 2) return nums.length;
		int prev = 0;
		int moveTo = 0;
		for (int i = 2; i < nums.length; i++) {
			moveTo = i - prev;
			nums[moveTo] = nums[i];
			if (nums[moveTo] != nums[moveTo-2]) continue;
			else {
				prev += 1;
			}
		}

		return nums.length - prev;
	}

	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		int[] nums = new int[] {0,0,0,0,3,3,4,4,4,4,4,5,5,5,6,7,8,8};
		System.out.println(r.removeDuplicates(nums));
		for (int i: nums) System.out.print(i + " ");
	}
}