class MinOperations {
	public int minOperations(String s) {
		int n = s.length(), cnt0 = 0, cnt1 = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if ((i & 1) == 0) {
				if (c == '0') cnt1++;
				else cnt0++;
			} else {
				if (c == '0') cnt0++;
				else cnt1++;
			}
		}
		return Math.min(cnt0, cnt1);
	}

	public static void main(String[] args) {
		MinOperations mo = new MinOperations();
		System.out.println(mo.minOperations("0100"));
		System.out.println(mo.minOperations("10"));
		System.out.println(mo.minOperations("1111"));
	}
}