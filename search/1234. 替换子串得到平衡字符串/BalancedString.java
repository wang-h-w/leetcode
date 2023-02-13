class BalancedString {
	public int balancedString(String s) {
		int n = s.length(), each = n / 4;
		int[] memo = new int[26];
		for (int i = 0; i < n; i++) memo[s.charAt(i)-'A']++;
		if (memo['Q'-'A'] <= each && memo['W'-'A'] <= each && memo['E'-'A'] <= each && memo['R'-'A'] <= each) return 0;
		int l = 0, r = 0, ans = n;
		while (r < n) {
			memo[s.charAt(r)-'A']--;
			while (l <= r && memo['Q'-'A'] <= each && memo['W'-'A'] <= each && memo['E'-'A'] <= each && memo['R'-'A'] <= each) {
				ans = Math.min(ans, r - l + 1);
				memo[s.charAt(l++)-'A']++;
			}
			r++;
		}
		return ans;
	}
}