import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		// dp[i]记录到当前位置为止（需包含当前位置）整除子集的最大长度
		int n = nums.length, max = 1, maxIdx = 0;
		int[] dp = new int[n];
		List<Integer> ret = new LinkedList<>();
		Arrays.fill(dp, 1);
		Arrays.sort(nums);
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			if (dp[i] > max) {
				max = dp[i];
				maxIdx = i;
			}
		}
		
		for (int i = maxIdx; i >= 0; i--) {
			if (nums[maxIdx] % nums[i] == 0 && dp[i] == max) {
				ret.add(nums[i]);
				max--;
				maxIdx = i;
			}
		}
		
		return ret;
	}
}