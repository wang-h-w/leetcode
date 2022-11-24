class NumSubarrayBoundedMax {
	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		// 贡献度：每个nums[i]作为子数组右端点时，所能贡献的子数组个数
		int n = nums.length, ans = 0;
        for (int i = 0, j = -1, k = -1; i < n; i++) {
            if (nums[i] > right) {
                k = i;
            } else {
                if (nums[i] < left) {
                    if (j > k) ans += j - k;
                } else {
                    ans += i - k;
                    j = i;
                }
            }
        }
        return ans;
	}

	public static void main(String[] args) {
		NumSubarrayBoundedMax nsbm = new NumSubarrayBoundedMax();
		System.out.println(nsbm.numSubarrayBoundedMax(new int[] {2,1,4,3}, 2, 3));
		System.out.println(nsbm.numSubarrayBoundedMax(new int[] {2,9,2,5,6}, 2, 8));
	}
}