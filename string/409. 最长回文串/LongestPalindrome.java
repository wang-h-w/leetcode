class LongestPalindrome {
	public int longestPalindrome(String s) {
		int[] cnt = new int[26 * 2];
		int res = 0, single = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c > 'Z') cnt[c - 'a']++;
			else cnt[c - 'A' + 26]++;
		}
		for (int i : cnt) {
			res += i / 2;
			single += i % 2;
		}
		single = single >= 1 ? 1 : 0;
		return res * 2 + single;
	}

	public static void main(String[] args) {
		LongestPalindrome l = new LongestPalindrome();
		System.out.println(l.longestPalindrome("abccccdd"));
		System.out.println(l.longestPalindrome("a"));
	}
}