class MinWindow {
	public String minWindow(String s, String t) {
		int[] memo = new int[128], cnt = new int[128];
		int left = 0, right = 0, valid = 0, real = 0, start = 0, len = Integer.MAX_VALUE;
		for (int i = 0; i < t.length(); i++) memo[(int)t.charAt(i)]++;
		for (int i = 0; i < 128; i++) if (memo[i] != 0) real++;		
		while (right < s.length()) {
			int c = (int)s.charAt(right++);
			if (memo[c] != 0) {
				cnt[c]++;
				if (cnt[c] == memo[c]) valid++;
			}
			while (valid == real) {
				if (right - left < len) {
					start = left;
					len = right - left;
				}
				int d = (int)s.charAt(left++);
				if (memo[d] != 0) {
					if (cnt[d] == memo[d]) valid--;
					cnt[d]--;
				}
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}

	public static void main(String[] args) {
		MinWindow mw = new MinWindow();
		System.out.println(mw.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(mw.minWindow("a", "a"));
		System.out.println(mw.minWindow("a", "aa"));
		System.out.println(mw.minWindow("aa", "aa"));
	}
}