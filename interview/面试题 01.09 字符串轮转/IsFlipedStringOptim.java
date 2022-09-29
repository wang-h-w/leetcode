class IsFlipedStringOptim {
	public boolean isFlipedString(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		String ss = s2 + s2;
		return ss.contains(s1);
	}

	public static void main(String[] args) {
		IsFlipedStringOptim f = new IsFlipedStringOptim();
		System.out.println(f.isFlipedString("waterbottle", "erbottlewat"));
		System.out.println(f.isFlipedString("aa", "aba"));
		System.out.println(f.isFlipedString("waterbottle", "erbettlewat"));
	}
}