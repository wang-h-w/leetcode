import java.util.Arrays;

class NthSuperUglyNumberDP {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int m = primes.length;
		int[] dp = new int[n], indexes = new int[m];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int minIdx = 0;
			for (int j = 0; j < m; j++) {
				if (dp[indexes[j]] > Integer.MAX_VALUE / primes[j]) continue;
				if (dp[i] > primes[j] * dp[indexes[j]]) {
					dp[i] = primes[j] * dp[indexes[j]];
					minIdx = j;
				} else if (dp[i] == primes[j] * dp[indexes[j]]) {
					indexes[j]++;
				}
			}
			indexes[minIdx]++;
		}

		return dp[n-1];
	}

	public static void main(String[] args) {
		NthSuperUglyNumberDP n = new NthSuperUglyNumberDP();
		System.out.println(n.nthSuperUglyNumber(12, new int[] {2,7,13,19}));
		System.out.println(n.nthSuperUglyNumber(1, new int[] {2,3,5}));
	}
}