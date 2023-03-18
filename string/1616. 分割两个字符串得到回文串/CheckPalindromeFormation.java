class CheckPalindromeFormation {
	public boolean checkPalindromeFormation(String a, String b) {
		return check(a, b) || check(b, a);
	}

	private boolean check(String a, String b) {
		int l = 0, r = a.length() - 1;
		while (l < r && s.charAt(l) == s.charAt(r)) {l++; r--;}
		return isPalindrome(a, l, r) || isPalindrome(b, l, r);
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j && s.charAt(i) == s.charAt(j)) {i++; j--;}
		return i >= j;
	}
}