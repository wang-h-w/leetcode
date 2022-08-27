class MaxProduct {
	public int maxProduct(String[] words) {
		int n = words.length, max = 0;
		int[] binary = new int[n];

		for (int i = 0; i < n; i++) {
			for (char c : words[i].toCharArray()) binary[i] |= 1 << (c - 'a');
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((binary[i] & binary[j]) == 0) max = Math.max(words[i].length() * words[j].length(), max);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		MaxProduct mp = new MaxProduct();
		System.out.println(mp.maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}));
		System.out.println(mp.maxProduct(new String[] {"a","ab","abc","d","cd","bcd","abcd"}));
		System.out.println(mp.maxProduct(new String[] {"a","aa","aaa","aaaa"}));
	}
}