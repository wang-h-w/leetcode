class IsPowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		IsPowerOfTwo p = new IsPowerOfTwo();
		System.out.println(p.isPowerOfTwo(1));
		System.out.println(p.isPowerOfTwo(16));
		System.out.println(p.isPowerOfTwo(3));
		System.out.println(p.isPowerOfTwo(4));
		System.out.println(p.isPowerOfTwo(5));
	}
}