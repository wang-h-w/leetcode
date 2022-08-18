class NumArray {
	int[] nums, sum;

	public NumArray(int[] nums) {
		this.nums = nums;
		this.sum = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) sum[i+1] = sum[i] + nums[i];
	}

	public void update(int index, int val) {
		int change = val - nums[index];
		nums[index] = val;
		for (int i = index + 1; i < nums.length + 1; i++) sum[i] += change;
	}

	public int sumRange(int left, int right) {
		return sum[right+1] - sum[left];
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,1,4};
		NumArray n = new NumArray(nums);
		System.out.println(n.sumRange(1,4));
		n.update(3,4);
		System.out.println(n.sumRange(1,4));
	}
}