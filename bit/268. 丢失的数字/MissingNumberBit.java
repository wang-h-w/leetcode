class MissingNumberBit {
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
			res ^= i;
		}
		return res;
	}

	public static void main(String[] args) {
		MissingNumberBit m = new MissingNumberBit();
		System.out.println(m.missingNumber(new int[] {3,0,1}));
		System.out.println(m.missingNumber(new int[] {0,1}));
		System.out.println(m.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
		System.out.println(m.missingNumber(new int[] {0}));
	}
}