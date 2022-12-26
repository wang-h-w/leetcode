class CountHomogenous {
	public int countHomogenous(String s) {
		int n = s.length(), p1 = 0, p2 = 0, MOD = 1000000007;
		long res = 0;
		while (p2 < n) {
			char c = s.charAt(p2);
			if (c != s.charAt(p1)) {
				res += (long) (1 + p2 - p1) * (p2 - p1) / 2;
				p1 = p2;
			}
			p2++;
		}
		res += (long) (1 + p2 - p1) * (p2 - p1) / 2;
		return (int)(res % MOD);
	}

	public static void main(String[] args) {
		CountHomogenous ch = new CountHomogenous();
		System.out.println(ch.countHomogenous("abbcccaa"));
		System.out.println(ch.countHomogenous("xy"));
		System.out.println(ch.countHomogenous("zzzzz"));
	}
}