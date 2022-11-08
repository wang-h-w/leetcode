class CountConsistentStrings {
	public int countConsistentStrings(String allowed, String[] words) {
		int allow = f(allowed), res = 0;
		for (String word : words) {
			if ((allow | f(word)) == allow) res++;
		}
		return res;
	}

	private int f(String word) {
		int mask = 0;
		for (int i = 0; i < word.length(); i++) {
			mask |= 1 << (word.charAt(i) - 'a');
		}
		return mask;
	}

	public static void main(String[] args) {
		CountConsistentStrings cnt = new CountConsistentStrings();
		System.out.println(cnt.countConsistentStrings("ab", new String[] {"ad","bd","aaab","baa","badab"}));
		System.out.println(cnt.countConsistentStrings("abc", new String[] {"a","b","c","ab","ac","bc","abc"}));
		System.out.println(cnt.countConsistentStrings("cad", new String[] {"cc","acd","b","ba","bac","bad","ac","d"}));
	}
}