class CountAndSay {
	public String countAndSay(int n) {
		return count(String.valueOf(1), n);
	}

	private String count(String s, int n) {
		if (n == 1) return s;
		String ret = "";
		int num = 1;
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1 || s.charAt(i) != s.charAt(i+1)) {
				ret += String.valueOf(num);
				ret += String.valueOf(s.charAt(i));
				num = 1;
				continue;
			}
			num++;
		}
		return count(ret, --n);
	}

	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(5));
	}
}