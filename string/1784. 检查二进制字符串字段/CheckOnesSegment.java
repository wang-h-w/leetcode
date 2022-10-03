class CheckOnesSegment {
	public boolean checkOnesSegment(String s) {
		boolean hasZero = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '1' && hasZero) return false;
			else if (c == '1') continue;
			else hasZero = true;
		}
		return true;
	}

	public static void main(String[] args) {
		CheckOnesSegment check = new CheckOnesSegment();
		System.out.println(check.checkOnesSegment("1001"));
		System.out.println(check.checkOnesSegment("110"));
		System.out.println(check.checkOnesSegment("10000001"));
	}
}