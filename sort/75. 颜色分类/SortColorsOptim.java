class SortColors {
	public void sortColors(int[] nums) {
		int num0 = 0, num1 = 0, num2 = 0;  // 存储每个数字区域的末位索引
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else {
                nums[num2++] = 2;
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