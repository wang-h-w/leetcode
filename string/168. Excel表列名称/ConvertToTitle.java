class ConvertToTitle {
	public String convertToTitle(int columnNumber) {
		StringBuffer sb = new StringBuffer();
		while (columnNumber > 0) {
			columnNumber--;
			sb.append((char)(columnNumber % 26 + 'A'));
			columnNumber /= 26;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		ConvertToTitle c = new ConvertToTitle();
		System.out.println(c.convertToTitle(1));
		System.out.println(c.convertToTitle(28));
		System.out.println(c.convertToTitle(52));
		System.out.println(c.convertToTitle(701));
		System.out.println(c.convertToTitle(2147483647));
	}
}