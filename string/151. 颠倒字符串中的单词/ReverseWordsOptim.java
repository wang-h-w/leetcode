class ReverseWords {
	public String reverseWords(String s) {
		// 反转所有
		StringBuilder sb = new StringBuilder(s.trim());
		int l = 0, r = 0;
		sb = reverse(sb, 0, sb.length() - 1);
		// 逐一再反转
		while (r < sb.length()) {
			while (r < sb.length() && sb.charAt(r) != ' ') r++;
			sb = reverse(sb, l, r - 1);
			r++;
			while (r < sb.length() && sb.charAt(r) == ' ') sb = sb.deleteCharAt(r);
			l = r;
		}
		return sb.toString();
	}

	private StringBuilder reverse(StringBuilder sb, int l, int r) {
		while (l < r) {
			char temp = sb.charAt(l);
			sb.setCharAt(l++, sb.charAt(r));
			sb.setCharAt(r--, temp);
		}
		return sb;
	}

	public static void main(String[] args) {
		ReverseWords r = new ReverseWords();
		System.out.println(r.reverseWords("a good   example"));
		System.out.println(r.reverseWords("  hello  world  "));
		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(r.reverseWords("      "));
	}
}