class IsFlipedString {
	public boolean isFlipedString(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		if (n1 != n2) return false;
		if (n1 == 0) return true;
		for (int i = 1; i <= n1; i++) {
			String substring1 = s1.substring(0, i);
			String substring2 = s1.substring(i, n1);
			String concat = substring2 + substring1;
			if (concat.equals(s2)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		IsFlipedString f = new IsFlipedString();
		System.out.println(f.isFlipedString("waterbottle", "erbottlewat"));
		System.out.println(f.isFlipedString("aa", "aba"));
		System.out.println(f.isFlipedString("waterbottle", "erbettlewat"));
	}
}