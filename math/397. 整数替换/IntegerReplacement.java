class IntegerReplacement {
	public int integerReplacement(int n) {
		if (n == 1) return 0;
		if (n == Integer.MAX_VALUE) return integerReplacement(n - 1);
		if (n % 2 == 0) return 1 + integerReplacement(n / 2);
		else return 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
	}

	public static void main(String[] args) {
		IntegerReplacement i = new IntegerReplacement();
		System.out.println(i.integerReplacement(8));
		System.out.println(i.integerReplacement(7));
		System.out.println(i.integerReplacement(163652839));
	}
}