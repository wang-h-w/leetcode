import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class MinimumTotal {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null) return 0;
		// 二维数组记录历史信息：(i,j)为到当前点的最小路径和
		int n = triangle.size();
		int[] dp = new int[n];
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i-1] + triangle.get(i).get(i);
			for (int j = i - 1; j > 0; j--) {
				dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
			}
			dp[0] = dp[0] + triangle.get(i).get(0);
		}

		Arrays.sort(dp);
		return dp[0];
	}
}