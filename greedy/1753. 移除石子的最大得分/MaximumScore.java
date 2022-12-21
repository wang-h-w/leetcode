class MaximumScore {
	public int maximumScore(int a, int b, int c) {
		int ans = 0;
		int[] memo = new int[] {a, b, c};
		Arrays.sort(memo);
		while (memo[0] != 0 || memo[1] != 0) {
			ans++;
			memo[1]--;
			memo[2]--;
			Arrays.sort(memo);
		}
		return ans;
	}
}