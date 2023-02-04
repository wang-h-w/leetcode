class GetMaximumConsecutive {
	public int getMaximumConsecutive(int[] coins) {
		int m = 0;
		Arrays.sort(coins);
		for (int c : coins) {
			if (c > m + 1) break;
			m += c;
		}
		return m + 1;
	}
}