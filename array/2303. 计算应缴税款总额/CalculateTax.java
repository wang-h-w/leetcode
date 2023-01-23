class CalculateTax {
	public double calculateTax(int[][] brackets, int income) {
		double res = 0.0;
		int prev = 0;
		for (int[] bracket : brackets) {
			if (income <= 0) break;
			int pay = Math.min(income, bracket[0] - prev);
			res += pay * 1.0 * bracket[1] / 100;
			income -= pay;
			prev = bracket[0];
		}
		return res;
	}
}