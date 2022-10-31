class AddStrings {
	public String addStrings(String num1, String num2) {
		if (num1.length() > num2.length()) return addStrings(num2, num1);
		StringBuffer sb1 = new StringBuffer(num1), sb2 = new StringBuffer(num2), sb = new StringBuffer();
		sb1.reverse();
		sb2.reverse();
		boolean carry = false;
		int ptr = 0;
		while (carry || ptr < sb2.length()) {
			char n = 0;
			if (ptr < sb1.length()) n = (char)(n + sb1.charAt(ptr) - '0');
			if (ptr < sb2.length()) n = (char)(n + sb2.charAt(ptr));
			if (carry) {
				if (n == 0) n = '1';
				else n = (char)(n + 1);
			}
			if (n > '9') {
				sb.append((char)('0' + n - '9' - 1));
				carry = true;
			} else {
				sb.append(n);
				carry = false;
			}
			ptr++;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		AddStrings as = new AddStrings();
		System.out.println(as.addStrings("11","123"));
		System.out.println(as.addStrings("456","77"));
		System.out.println(as.addStrings("100000","999999"));
	}
}