class MergeAlternately {
	public String mergeAlternately(String word1, String word2) {
		StringBuffer sb = new StringBuffer();
		int n1 = word1.length(), n2 = word2.length(), i = 0;
		while (i < n1 && i < n2) {
			sb.append(word1.charAt(i));
			sb.append(word2.charAt(i++));
		}
		while (i < n1) sb.append(word1.charAt(i++));
		while (i < n2) sb.append(word2.charAt(i++));
		return sb.toString();
	}

	public static void main(String[] args) {
		MergeAlternately merge = new MergeAlternately();
		System.out.println(merge.mergeAlternately("abc", "pqr"));
		System.out.println(merge.mergeAlternately("ab", "pqrs"));
		System.out.println(merge.mergeAlternately("abcd", "pq"));
	}
}