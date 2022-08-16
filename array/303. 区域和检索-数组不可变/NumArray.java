class NumArray {
	int[] numsSum;
	public NumArray(int[] nums) {
		numsSum = new int[nums.length + 1];
		numsSum[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			numsSum[i+1] = numsSum[i] + nums[i];
		}
	}

	public int sumRange(int left, int right) {
		return numsSum[right+1] - numsSum[left];
	}

	public static void main(String[] args) {
		NumArray obj = new NumArray(new int[] {-2,0,3,-5,2,-1});
		System.out.println(obj.sumRange(0, 2));
		System.out.println(obj.sumRange(2, 5));
		System.out.println(obj.sumRange(0, 5));
	}
}