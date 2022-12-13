class CheckIfPangram {
	public boolean checkIfPangram(String sentence) {
		boolean[] memo = new boolean[26];
		int cnt = 26;
		for (int i = 0; i < sentence.length(); i++) {
			int c = sentence.charAt(i) - 'a';
			if (!memo[c]) cnt--;
			if (cnt == 0) return true;
			memo[c] = true;
		}
		return false;
	}
}