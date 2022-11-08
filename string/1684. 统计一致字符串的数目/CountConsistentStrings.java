class CountConsistentStrings {
	public int countConsistentStrings(String allowed, String[] words) {
		boolean[] allow = new boolean[26];
		int res = 0; boolean flag = false;
		for (int i = 0; i < allowed.length(); i++) allow[allowed.charAt(i) - 'a'] = true;
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!allow[c - 'a']) {
					flag = true;
					break;
				}
			}
			if (!flag) res++;
			flag = false;
		}
		return res;
	}

	public static void main(String[] args) {
		CountConsistentStrings cnt = new CountConsistentStrings();
		System.out.println(cnt.countConsistentStrings("ab", new String[] {"ad","bd","aaab","baa","badab"}));
		System.out.println(cnt.countConsistentStrings("abc", new String[] {"a","b","c","ab","ac","bc","abc"}));
		System.out.println(cnt.countConsistentStrings("cad", new String[] {"cc","acd","b","ba","bac","bad","ac","d"}));
	}
}