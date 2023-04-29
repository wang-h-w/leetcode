class EqualFrequency {
	public boolean equalFrequency(String word) {
		int[] memo = new int[26];
		for (int i = 0; i < word.length(); i++) memo[word.charAt(i) - 'a']++;
		for (int i = 0; i < 26; i++) {
			memo[i]--;
			if (memo[i] != -1 && check(memo)) return true;
			memo[i]++;
		}
		return false;
	}

	private boolean check(int[] nums) {
		int pre = -1;
		for (int i = 0; i < 26; i++) {
			if (pre == -1 && nums[i] != 0) pre = nums[i];
			if (nums[i] != 0 && nums[i] != pre) return false;
		}
		return true;
	}
}