class RearrangeCharacters {
	public rearrangeCharacters(String s, String target) {
		int[] memo1 = new int[26], memo2 = new int[26];
		int res = Integer.MAX_VALUE;
		for (char c : s.toCharArray()) memo1[c - 'a']++;
		for (char c : target.toCharArray()) memo2[c - 'a']++;
		for (char c : target.toCharArray()) res = Math.min(res, memo1[c - 'a'] / memo2[c - 'a']);
		return res;
	}
}