class WiggleMaxLength {
	public int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		if (n == 1) return n;
		int res = nums[0] == nums[1] ? 1 : 2;
		int prevprev = 0;
		for (int curr = 2; curr < n; curr++) {
			if ((nums[curr] - nums[curr-1]) * (nums[curr-1] - nums[prevprev]) < 0 ||
				res == 1 && nums[curr] != nums[curr-1]) {
				res++;
				prevprev = curr - 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		WiggleMaxLength wiggle = new WiggleMaxLength();
		System.out.println(wiggle.wiggleMaxLength(new int[] {1,7,4,9,2,5}));
		System.out.println(wiggle.wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
		System.out.println(wiggle.wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9}));
		System.out.println(wiggle.wiggleMaxLength(new int[] {0,0}));
		System.out.println(wiggle.wiggleMaxLength(new int[] {0,0,0}));
		System.out.println(wiggle.wiggleMaxLength(new int[] {0,0,0,1}));
	}
}