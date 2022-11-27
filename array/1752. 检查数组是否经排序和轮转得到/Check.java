class Check {
	public boolean check(int[] nums) {
		int n = nums.length, cnt = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] < nums[i - 1]) cnt++;
		}
		if (nums[0] < nums[n - 1]) cnt++;
		return cnt == 0 || cnt == 1;
	}

	public static void main(String[] args) {
		Check c = new Check();
		System.out.println(c.check(new int[] {3,4,5,1,2}));
		System.out.println(c.check(new int[] {2,1,3,4}));
		System.out.println(c.check(new int[] {1,2,3}));
		System.out.println(c.check(new int[] {2,1,2,3}));
		System.out.println(c.check(new int[] {1,1,1}));
	}
}