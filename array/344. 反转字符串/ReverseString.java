class ReverseString {
	public void reverseString(char[] s) {
		int start = 0, end = s.length - 1;
		char temp;
		while (start < end) {
			temp = s[start];
			s[start++] = s[end];
			s[end--] = temp;
		}
	}

	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
		r.reverseString(s);
		for (char c : s) System.out.print(c + " ");
		System.out.println();
		s = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
		r.reverseString(s);
		for (char c : s) System.out.print(c + " ");
		System.out.println();
		s = new char[] {'H'};
		r.reverseString(s);
		for (char c : s) System.out.print(c + " ");
		System.out.println();
	}
}