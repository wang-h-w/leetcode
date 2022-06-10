class MySqrt {
	public int mySqrt(int x) {
		return sqrtHelper(x, 0, Math.min(x, 46341));
	}

	private int sqrtHelper(int value, int start, int end) {
		int center = (start + end) / 2;
		if (center == 46340) return center;
		if (center * center == value) return center;
		if ((center+1) * (center+1) == value) return center + 1;
		if (center * center < value && (center+1) * (center+1) > value) return center;
		if (center * center > value) return sqrtHelper(value, start, center);
		else return sqrtHelper(value, center, end);
	}

	public static void main(String[] args) {
		MySqrt sqrt = new MySqrt();
		System.out.println(sqrt.mySqrt(2147483647));
	}
}