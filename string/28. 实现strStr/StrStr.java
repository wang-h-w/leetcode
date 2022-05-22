class StrStr {
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {
		StrStr ss = new StrStr();
		System.out.println(ss.strStr("hello", "ll"));
	}
}