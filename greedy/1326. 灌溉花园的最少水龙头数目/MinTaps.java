import java.util.Arrays;

class MinTaps {
	public int minTaps(int n, int[] ranges) {
		int[][] memo = new int[n + 1][2];
		for (int i = 0; i <= n; i++) {
			memo[i][0] = Math.max(i - ranges[i], 0);
			memo[i][1] = Math.min(i + ranges[i], n);
		}
		Arrays.sort(memo, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

		int res = 0, r = 0, temp = 0;
		while (r < n) {
			int max = -1;
			while (temp <= n && memo[temp][0] <= r) {
				max = Math.max(max, memo[temp][1]);
				temp++;
			}
			if (max == -1) return -1;
			r = max;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		MinTaps mt = new MinTaps();
		System.out.println(mt.minTaps(5, new int[] {3,4,1,1,0,0}));
		System.out.println(mt.minTaps(7, new int[] {1,2,1,0,2,1,0,1}));
	}
}