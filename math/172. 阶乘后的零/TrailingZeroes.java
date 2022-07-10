class TrailingZeroes {
	public int trailingZeroes(int n) {
		int res = 0;
		while (n / 5 != 0) {
			res += n / 5;
			n /= 5;
		}

		return res;
	}

	public static void main(String[] args) {
		TrailingZeroes t = new TrailingZeroes();
		System.out.println(t.trailingZeroes(3));
		System.out.println(t.trailingZeroes(5));
		System.out.println(t.trailingZeroes(15));
	}
}