class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
	}

	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		int[] nums = new int[] {0,0,0,0,3,3,4,4,4,4,4,5,5,5,6,7,8,8};
		System.out.println(r.removeDuplicates(nums));
		for (int i: nums) System.out.print(i + " ");
	}
}