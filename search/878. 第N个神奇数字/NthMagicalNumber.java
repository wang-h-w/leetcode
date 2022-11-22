class NthMagicalNumber {
	private int a, b, c, n;
	private final int MOD = (int)1e9 + 7;

	public int nthMagicalNumber(int n, int a, int b) {
		// f(x)为小于等于x的神奇数字的数量，f(x)=n时的x即为所求
		this.a = a; this.b = b; this.c = lcm(a, b); this.n = n;
		long l = 0, r = (long)1e20;
		while (l < r) {
			long mid = l + r >> 1;
			if (check(mid) >= n) r = mid;
			else l = mid + 1;
		}
		return (int)(r % MOD);

	}

	private long check(long x) {
		return x / a + x / b - x / c;
	}

	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void main(String[] args) {
		NthMagicalNumber n = new NthMagicalNumber();
		System.out.println(n.nthMagicalNumber(1,2,3));
		System.out.println(n.nthMagicalNumber(4,2,3));
	}
}