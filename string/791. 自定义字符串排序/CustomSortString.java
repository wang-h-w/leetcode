class CustomSortString {
	public String customSortString(String order, String s) {
		StringBuffer sb = new StringBuffer();
		int[] memo = new int[26];
		for (int i = 0; i < s.length(); i++) memo[s.charAt(i)-'a']++;
		for (int i = 0; i < order.length(); i++) {
			char c = order.charAt(i);
			while (memo[c-'a']-- > 0) sb.append(c);
		}
		for (int i = 0; i < 26; i++) {
			while (memo[i]-- > 0) sb.append((char)(i + 'a'));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		CustomSortString sort = new CustomSortString();
		System.out.println(sort.customSortString("cba", "abcd"));
		System.out.println(sort.customSortString("cbafg", "abcd"));
	}
}