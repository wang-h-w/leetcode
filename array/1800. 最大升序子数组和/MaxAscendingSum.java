class MaxAscendingSum {
	public int maxAscendingSum(int[] nums) {
		int max = Integer.MIN_VALUE, ptr = 1, sum = nums[0];
		while (ptr < nums.length) {
			if (nums[ptr] > nums[ptr - 1]) sum += nums[ptr++];
			else {
				max = Math.max(max, sum);
				sum = nums[ptr++];
			}
		}
		max = Math.max(max, sum);
		return max;
	}

	public static void main(String[] args) {
		MaxAscendingSum a = new MaxAscendingSum();
		System.out.println(a.maxAscendingSum(new int[] {10,20,30,5,10,50}));
		System.out.println(a.maxAscendingSum(new int[] {10,20,30,40,50}));
		System.out.println(a.maxAscendingSum(new int[] {12,17,15,13,10,11,12}));
		System.out.println(a.maxAscendingSum(new int[] {100,10,1}));
		System.out.println(a.maxAscendingSum(new int[] {1}));
	}
}