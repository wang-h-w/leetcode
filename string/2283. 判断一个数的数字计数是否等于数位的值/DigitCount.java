class DigitCount {
	public boolean digitCount(String num) {
		int n = num.length();
		int[] memo = new int[n];
		for (int i = 0; i < n; i++) {
			if (num.charAt(i) - '0' >= n) continue;
			memo[num.charAt(i) - '0']++;
		}
		for (int i = 0; i < n; i++) {
			if (num.charAt(i) - '0' != memo[i]) return false;
		}
		return true;
	}
}