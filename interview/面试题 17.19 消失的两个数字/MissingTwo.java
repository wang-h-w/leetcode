class MissingTwo {
	public int[] missingTwo(int[] nums) {
		int n = nums.length, actualSum = 0, halfSum = 0;
		for (int i : nums) actualSum += i;
		int wantSum = (1 + n + 2) * (n + 2) / 2;
		int sum = wantSum - actualSum, limit = sum / 2; // 肯定一个比中值小，另一个比中值大
		for (int i : nums) if (i <= limit) halfSum += i;
		int[] res = new int[2];
		res[0] = (1 + limit) * limit / 2 - halfSum;
		res[1] = sum - res[0];
		return res;
	}

	public static void main(String[] args) {
		MissingTwo mt = new MissingTwo();
		int[] res = mt.missingTwo(new int[] {1});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = mt.missingTwo(new int[] {2,3});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = mt.missingTwo(new int[] {1,5,2,4,7,6,9});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}