class IsPowerOfFour {
	public boolean isPowerOfFour(int n) {
		if (n < 1 || (n & (n - 1)) != 0) return false;
		return n % 3 == 1;
	}

	public static void main(String[] args) {
		IsPowerOfFour f = new IsPowerOfFour();
		System.out.println(f.isPowerOfFour(16));
		System.out.println(f.isPowerOfFour(5));
		System.out.println(f.isPowerOfFour(1));
	}
}