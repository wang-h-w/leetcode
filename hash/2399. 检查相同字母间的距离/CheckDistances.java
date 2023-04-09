class CheckDistances {
	public boolean checkDistances(String s, int[] distance) {
		int[] memo = new int[26];
		Arrays.fill(memo, -1);
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			if (memo[idx] != -1) memo[idx] = i - memo[idx] - 1;
			else memo[idx] = i;
		}
		for (int i = 0; i < distance.length; i++) {
			if (memo[i] != -1 && memo[i] != distance[i]) return false;
		}
		return true;
	}
}