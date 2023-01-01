class RepeatedCharacter {
	public char repeatedCharacter(String s) {
		boolean[] memo = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			if (memo[idx]) return s.charAt(i);
			memo[idx] = true;
		}
		return 'a';
	}
}