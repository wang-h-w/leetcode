class LongestPalindrome {
	public String longestPalindrome(String s) {
		int n = s.length();
		String res = "";
		for (int i = 0; i < 2 * n - 1; i++) {
			int l = i / 2, r = (i + 1) / 2;
			while (l >= 0 && r < n) {
				if (s.charAt(l) != s.charAt(r)) break;
				l--; r++;
			}
			String t = s.substring(l + 1, r);
			if (t.length() > res.length()) res = t;
		}
		return res;
	}
}