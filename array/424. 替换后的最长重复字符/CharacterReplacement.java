class CharacterReplacement {
	public int characterReplacement(String s, int k) {
		// 滑动窗口的典型题目，max为窗口内相同字符的最大出现次数
		int[] memo = new int[26];
		int left = 0, right = 0, max = Integer.MIN_VALUE;
		while (right < s.length()) {
			int idx = s.charAt(right) - 'A';
			memo[idx]++;
			max = Math.max(memo[idx], max);
			if (right - left + 1 > max + k) {
				memo[s.charAt(left) - 'A']--;
				left++;
			};
			right++;
		}
		return right - left;
	}
}