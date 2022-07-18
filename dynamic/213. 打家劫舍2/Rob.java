import java.util.Arrays;

class Rob {
	public int rob(int[] nums) {
		if (nums.length == 1) return nums[0];
		int a = robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1));
		int b = robHelper(Arrays.copyOfRange(nums, 1, nums.length));
		return Math.max(a, b);
	}

	private int robHelper(int[] nums) {
		int len = nums.length;
		if (len == 0) return 0;
		if (len == 1) return nums[0];
		if (len == 2) return Math.max(nums[0], nums[1]);
		int[] dp = new int[len];
		dp[0] = nums[0];
		dp[1] = nums[1];
		dp[2] = nums[0] + nums[2];
		int max = Math.max(dp[1], dp[2]);

		for (int i = 3; i < len; i++) {
			dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Rob r = new Rob();
		System.out.println(r.rob(new int[] {2,3,2}));
		System.out.println(r.rob(new int[] {1,2,3,1}));
		System.out.println(r.rob(new int[] {1,2,3}));
	}
}