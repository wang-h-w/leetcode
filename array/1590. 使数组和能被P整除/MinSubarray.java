class MinSubarray {
	public int minSubarray(int[] nums, int p) {
		// 前缀和
		int n = nums.length;
		long[] sum = new long[n];
		sum[0] = nums[0];
		for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + nums[i];
		if (sum[n - 1] % p == 0) return 0;
		// 遍历
		for (int interval = 1; interval < n; interval++) {
			int l = 0, r = l + interval - 1;
			while (r < n) {
				long currSum = l > 0 ? sum[n - 1] - sum[r] + sum[l -1] : sum[n - 1] - sum[r];
				if (currSum % p == 0) return interval;
				l++; r++;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MinSubarray ms = new MinSubarray();
		System.out.println(ms.minSubarray(new int[] {3,1,4,2}, 6));
		System.out.println(ms.minSubarray(new int[] {6,3,5,2}, 9));
		System.out.println(ms.minSubarray(new int[] {1,2,3}, 3));
		System.out.println(ms.minSubarray(new int[] {1,2,3}, 7));
		System.out.println(ms.minSubarray(new int[] {1000000000,1000000000,1000000000}, 3));
	}
}