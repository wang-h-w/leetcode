import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class BoxDelivering {
	// 必须用单调队列优化，否则O(N2)的时间复杂度必超时
	public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
		int n = boxes.length;
		// dp[i]运送前i个箱子的最少行程次数
		int[] dp = new int[n + 1], preSum = new int[n + 1], prePort = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE); dp[0] = 0;
		// 前缀和
		for (int i = 1; i <= n; i++) {
			preSum[i] = preSum[i - 1] + boxes[i - 1][1];
			prePort[i] = prePort[i - 1];
			if (i == 1) prePort[i]++;
			else if (boxes[i - 1][0] != boxes[i - 2][0]) prePort[i] += 1;
		}
		// 动态规划 + 单调队列
		Deque<Integer> d = new LinkedList<>(); // store index
		d.offer(1);
		for (int i = 1; i <= n; i++) {
			while (!d.isEmpty() && (i - d.peekFirst() + 1 > maxBoxes || preSum[i] - preSum[d.peekFirst() - 1] > maxWeight)) d.pollFirst();
			if (!d.isEmpty()) dp[i] = dp[d.peekFirst() - 1] + 2 + (prePort[i] - prePort[d.peekFirst()]);
			if (i < n) {
				while (!d.isEmpty() && dp[d.peekLast() - 1] - prePort[d.peekLast()] >= dp[i] - prePort[i + 1]) d.pollLast();
				d.offer(i + 1);
			}
			
			// for (int j = i; j >= 1; j--) {
			// 	if (preSum[i] - preSum[j - 1] > maxWeight || i - j + 1 > maxBoxes) break;
			// 	dp[i] = Math.min(dp[i], dp[j - 1] + 2 + (prePort[i] - prePort[j]));
			// }
		}
		return dp[n];
	}

	public static void main(String[] args) {
		BoxDelivering bd = new BoxDelivering();
		System.out.println(bd.boxDelivering(new int[][] {{1,1},{2,1},{1,1}}, 2, 3, 3));
		System.out.println(bd.boxDelivering(new int[][] {{1,2},{3,3},{3,1},{3,1},{2,4}}, 3, 3, 6));
		System.out.println(bd.boxDelivering(new int[][] {{1,4},{1,2},{2,1},{2,1},{3,2},{3,4}}, 3, 6, 7));
		System.out.println(bd.boxDelivering(new int[][] {{2,4},{2,5},{3,1},{3,2},{3,7},{3,1},{4,4},{1,3},{5,2}}, 5, 5, 7));
	}
}