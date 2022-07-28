class IsUgly {
	public boolean isUgly(int n) {
		if (n == 1 || n == 2 || n == 3 || n == 5) return true;
		if (n % 2 != 0 && n % 3 != 0 && n % 5 != 0 || n <= 0) return false;
		if (n % 5 == 0) return isUgly(n / 5);
		else if (n % 3 == 0) return isUgly(n / 3);
		else return isUgly(n / 2);
	}

	public static void main(String[] args) {
		IsUgly u = new IsUgly();
		System.out.println(u.isUgly(6));
		System.out.println(u.isUgly(1));
		System.out.println(u.isUgly(14));
		System.out.println(u.isUgly(0));
	}
}