class AreSentencesSimilar {
	public boolean areSentencesSimilar(String sentence1, String sentence2) {
		String[] s1 = sentence1.split(" "), s2 = sentence2.split(" ");
		if (sentence1.equals(sentence2)) return true;
		int min = Math.min(s1.length, s2.length), prefix = 0, suffix = 0;
		for (int i = 0; i < min; i++) {
			if (!s1[i].equals(s2[i])) break;
			prefix++;
		}
		for (int i = s1.length - 1, j = s2.length - 1; i >= 0 && j >= 0; i--, j--) {
			if (!s1[i].equals(s2[j])) break;
			suffix++;
		}
		return prefix + suffix >= min;
	}
}