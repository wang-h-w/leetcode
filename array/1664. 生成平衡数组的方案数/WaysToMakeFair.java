class WaysToMakeFair {
	public int waysToMakeFair(int[] nums) {
		int n = nums.length, evenSum = 0, oddSum = 0, res = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) evenSum += nums[i];
			else oddSum += nums[i];
		}

		int currEvenSum = 0, currOddSum = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				if (currEvenSum + oddSum - currOddSum == currOddSum + evenSum - currEvenSum - nums[i]) res++;
				currEvenSum += nums[i];
			} else {
				if (currEvenSum + oddSum - currOddSum - nums[i] == currOddSum + evenSum - currEvenSum) res++;
				currOddSum += nums[i];
			}
		}
		return res;
 	}

	public static void main(String[] args) {
		WaysToMakeFair wtmk = new WaysToMakeFair();
		System.out.println(wtmk.waysToMakeFair(new int[] {2,1,6,4}));
		System.out.println(wtmk.waysToMakeFair(new int[] {1,1,1}));
		System.out.println(wtmk.waysToMakeFair(new int[] {1,2,3}));
	}
}