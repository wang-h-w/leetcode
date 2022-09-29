class MaxRotateFunction {
	public int maxRotateFunction(int[] nums) {
		int n = nums.length;
		int simpleSum = 0, funcSum = 0, last = 0, ptr = n - 1;
		for (int i = 0; i < n; i++) {
			simpleSum += nums[i];
			funcSum += i * nums[i];
		}
		int max = funcSum;

		for (int i = 0; i < n; i++) {
			funcSum += simpleSum - nums[ptr] - nums[ptr] * (n - 1);
			max = Math.max(funcSum, max);
			ptr--;
		}

		return max;
	}

	public static void main(String[] args) {
		MaxRotateFunction rot = new MaxRotateFunction();
		System.out.println(rot.maxRotateFunction(new int[] {4,3,2,6}));
		System.out.println(rot.maxRotateFunction(new int[] {0}));
		System.out.println(rot.maxRotateFunction(new int[] {3,4,2,10,42,21,32,4,5,2,34}));
	}
}