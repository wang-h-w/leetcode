class IsPalindrome {
	public boolean isPalindrome(String s) {
		if (s == "") return true;
		s = s.toLowerCase();
		int front = 0;
		int end = s.length() - 1;
		while (front < end) {
			char f = s.charAt(front);
			while (front < end && !('a' <= f && f <= 'z' || '0' <= f && f <= '9')) f = s.charAt(++front);
			char e = s.charAt(end);
			while (front < end && !('a' <= e && e <= 'z' || '0' <= e && e <= '9')) e = s.charAt(--end);
			if (f != e) return false;
			front++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		IsPalindrome is = new IsPalindrome();
		System.out.println(is.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(is.isPalindrome("race a car"));
		System.out.println(is.isPalindrome("0P"));
	}
}