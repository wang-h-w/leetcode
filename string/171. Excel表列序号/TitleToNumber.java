class TitleToNumber {
	public int titleToNumber(String columnTitle) {
		int res = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		TitleToNumber t = new TitleToNumber();
		System.out.println(t.titleToNumber("A"));
		System.out.println(t.titleToNumber("AB"));
		System.out.println(t.titleToNumber("AZ"));
		System.out.println(t.titleToNumber("ZY"));
		System.out.println(t.titleToNumber("FXSHRXW"));
	}
}