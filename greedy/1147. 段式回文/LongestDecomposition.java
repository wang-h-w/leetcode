class LongestDecomposition {
	public int longestDecomposition(String s) {
		if (s.isEmpty()) return 0;
		for (int i = 1, n = s.length(); i <= n / 2; i++) {
			if (s.substring(0, i).equals(s.substring(n - i))) return 2 + longestDecomposition(s.substring(i, n - i));
		}
		return 1;
	}
}