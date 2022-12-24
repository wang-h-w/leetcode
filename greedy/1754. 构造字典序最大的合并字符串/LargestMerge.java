class LargestMerge {
	public String largestMerge(String word1, String word2) {
		StringBuffer sb = new StringBuffer();
		int p1 = 0, p2 = 0, n1 = word1.length(), n2 = word2.length();
		while (p1 < n1 && p2 < n2) {
			char c1 = word1.charAt(p1), c2 = word2.charAt(p2);
			if (c1 == c2) {
				if (word1.substring(p1).compareTo(word2.substring(p2)) > 0) { sb.append(c1); p1++; }
				else { sb.append(c2); p2++; }
			} else {
				sb.append(c1 > c2 ? c1 : c2);
				p1 = c1 > c2 ? p1 + 1 : p1;
				p2 = c1 > c2 ? p2 : p2 + 1;
			}
		}
		if (p1 < n1) sb.append(word1.substring(p1));
		if (p2 < n2) sb.append(word2.substring(p2));
		return sb.toString();
	}

	public static void main(String[] args) {
		LargestMerge lm = new LargestMerge();
		System.out.println(lm.largestMerge("cabaa", "bcaaa"));
		System.out.println(lm.largestMerge("abcabc", "abdcaba"));
	}
}