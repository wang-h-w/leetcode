class Newton {
	public int mySqrt(int x) {
		if (x == 0) return 0;
		double error = 1e-6;
		double x0 = x, c = x;

		while (true) {
			double xi = 0.5 * (x0 + c / x0);
			if (Math.abs(xi - x0) < error) break;
			x0 = xi;
		}

		return (int)x0;
	}

	public static void main(String[] args) {
		Newton sqrt = new Newton();
		System.out.println(sqrt.mySqrt(2147483647));
	}
}