class MissingNumber {
	public int missingNumber(int[] nums) {
		int sum = 0, target = 0;
		for (int i : nums) sum += i;
		for (int i = 0; i <= nums.length; i++) target += i;
		return target - sum;
	}

	public static void main(String[] args) {
		MissingNumber m = new MissingNumber();
		System.out.println(m.missingNumber(new int[] {3,0,1}));
		System.out.println(m.missingNumber(new int[] {0,1}));
		System.out.println(m.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
		System.out.println(m.missingNumber(new int[] {0}));
	}
}