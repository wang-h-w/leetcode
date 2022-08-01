class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int p1 = 0, p2 = 0;
		while (p2 <= nums.length - 1) {
			while (nums[p2] == 0 && p2 < nums.length - 1) p2++;
			if (p1 != p2) {
				int temp = nums[p2];
				nums[p2] = nums[p1];
				nums[p1] = temp;
			}
			p1++;
			p2++;
		}
	}

	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		int[] nums = new int[] {0,1,0,3,12};
		mz.moveZeroes(nums);
		for (int i : nums) System.out.print(i + " ");
		System.out.println();
		nums = new int[] {0};
		mz.moveZeroes(nums);
		for (int i : nums) System.out.print(i + " ");
		System.out.println();
		nums = new int[] {0,1};
		mz.moveZeroes(nums);
		for (int i : nums) System.out.print(i + " ");
		System.out.println();
	}
}