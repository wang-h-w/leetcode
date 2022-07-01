class SingleNumber {
	public int singleNumber(int[] nums) {
		// 要求不使用额外空间，就往位运算上想
		// 位异或：如果两个数相同，则异或后为零
		// 任何数与零异或，结果不变
		int result = 0;
		for (int n: nums) result ^= n;
		return result;
	}

	public static void main(String[] args) {
		SingleNumber single = new SingleNumber();
		int[] nums = new int[] {4,1,2,1,2};
		System.out.println(single.singleNumber(nums));
	}
}