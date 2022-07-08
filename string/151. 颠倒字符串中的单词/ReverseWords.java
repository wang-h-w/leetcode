class ReverseWords {
	public String reverseWords(String s) {
		String ret = "";
		String temp = "";
		boolean prev = true;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ' && prev) continue;
			if (c == ' ') {
				if (ret.equals("")) ret = temp + ret;
				else ret = temp + " " + ret;
				temp = "";
				prev = true;
			} else {
				temp += String.valueOf(c);
				prev = false;
			}
		}
		if (!temp.equals("")) ret = temp + " " + ret;
		if (ret.equals("") && !temp.equals("")) return temp;

		return ret;
	}

	public static void main(String[] args) {
		ReverseWords r = new ReverseWords();
		System.out.println(r.reverseWords("a good   example"));
		System.out.println(r.reverseWords("  hello world  "));
		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(r.reverseWords("      "));
	}
}