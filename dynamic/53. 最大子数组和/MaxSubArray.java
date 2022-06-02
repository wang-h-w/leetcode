import java.util.Arrays;

class MaxSubArray {
	public int maxSubArray(int[] nums) {
		// 一维数组记录历史信息：以该点为结束的最大和（因为有连续性要求）
		int max = nums[0];
		int prev = nums[0];
		for (int i = 1; i < nums.length; i++) {
			prev = Math.max(prev + nums[i], nums[i]);
			max = Math.max(max, prev);
		}
		return max;
	}

	public static void main(String[] args) {
		MaxSubArray m = new MaxSubArray();
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		nums = new int[] {5,4,-1,7,8};
		nums = new int[] {1};
		nums = new int[] {1,2,-1,-2,2,1,-2,1,4,-5,4};
		System.out.println(m.maxSubArray(nums));
	}
}