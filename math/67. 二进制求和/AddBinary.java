class AddBinary {
	public String addBinary(String a, String b) {
		String ret = "";
		boolean carry = false;
		if (a.length() != b.length()) {
			if (a.length() < b.length()) {
				while (a.length() < b.length()) a = "0" + a;
			} else {
				while (b.length() < a.length()) b = "0" + b;
			}
		}
		for (int i = a.length() - 1; i >= 0 ; i--) {
			if (a.charAt(i) != b.charAt(i)) {
				if (carry) ret = "0" + ret;
				else ret = "1" + ret;
			}
			else if (a.charAt(i) == '0') {
				if (carry) {
					ret = "1" + ret;
					carry = false;
				} else ret = "0" + ret;
			}
			else {
				if (carry) ret = "1" + ret;
				else ret = "0" + ret;
				carry = true;
			}
		}
		if (carry) ret = "1" + ret;

		return ret;
	}

	public static void main(String[] args) {
		AddBinary add = new AddBinary();
		System.out.println(add.addBinary("111", "11"));
	}
}