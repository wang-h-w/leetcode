class ExpressiveWords {
	public int expressiveWords(String ss, String[] words) {
		int res = 0;
		char[] s = ss.toCharArray();
		for (String w : words) {
			char[] word = w.toCharArray();
			res += check(s, word);
		}
		return res;
	}

	private int check(char[] s, char[] word) {
		int i = 0, j = 0;
		while (i < s.length && j < word.length) {
			char first = s[i]; int cntS = 0, cntW = 0;
			while (i < s.length && s[i] == first) { cntS++; i++; }
			if (word[j] != first) return 0;
			while (j < word.length && word[j] == first) { cntW++; j++; }
			if ((cntW < cntS && cntS < 3) || cntW > cntS) return 0;
		}
		return i == s.length && j == word.length ? 1 : 0;
	}

	public static void main(String[] args) {
		ExpressiveWords ew = new ExpressiveWords();
		System.out.println(ew.expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"}));
		System.out.println(ew.expressiveWords("heeellooo", new String[] {"hellooo", "helllo", "helo"}));
	}
}