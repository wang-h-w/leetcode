class AreAlmostEqual {
	public boolean areAlmostEqual(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		if (s1.equals(s2)) return true;
		int cnt = 0;
		char[] first = new char[] {'0', '0'}, second = new char[] {'0', '0'};
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i), c2 = s2.charAt(i);
			if (c1 != c2) {
				cnt++;
				if (cnt == 1) {
					first[0] = c1;
					first[1] = c2;
				} else if (cnt == 2) {
					second[0] = c1;
					second[1] = c2;
				}
			}
			if (cnt > 2) return false;
		}
		return first[0] == second[1] && second[0] == first[1];
	}

	public static void main(String[] args) {
		AreAlmostEqual equal = new AreAlmostEqual();
		System.out.println(equal.areAlmostEqual("bank", "kanb"));
		System.out.println(equal.areAlmostEqual("attack", "defend"));
		System.out.println(equal.areAlmostEqual("kelb", "kelb"));
		System.out.println(equal.areAlmostEqual("abcd", "dcba"));
	}
}