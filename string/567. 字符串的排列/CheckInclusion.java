class CheckInclusion {
	public boolean checkInclusion(String s1, String s2) {
		int[] memo = new int[26], cnt = new int[26];
		int left = 0, right = 0, real = 0, valid = 0;
		for (int i = 0; i < s1.length(); i++) memo[s1.charAt(i) - 'a']++;
		for (int i = 0; i < 26; i++) if (memo[i] != 0) real++;
		while (right < s2.length()) {
			int c = s2.charAt(right++) - 'a';
			if (memo[c] != 0) {
				cnt[c]++;
				if (cnt[c] == memo[c]) valid++;
			}
			while (right - left >= s1.length()) {
				if (valid == real) return true;
				int d = s2.charAt(left++) - 'a';
				if (memo[d] != 0) {
					if (cnt[d] == memo[d]) valid--;
					cnt[d]--;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CheckInclusion ci = new CheckInclusion();
		System.out.println(ci.checkInclusion("ab", "eidbaooo"));
		System.out.println(ci.checkInclusion("ab", "eidboaoo"));
	}
}