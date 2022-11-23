class CountBalls {
	public int countBalls(int lowLimit, int highLimit) {
		int[] cnt = new int[46];
		for (int i = lowLimit; i <= highLimit; i++) {
			int sum = 0, temp = i;
			while (temp != 0) {
				sum += temp % 10;
				temp /= 10;
			}
			cnt[sum]++;
		}
		int max = 0;
		for (int x : cnt) max = Math.max(max, x);
		return max;
	}

	public static void main(String[] args) {
		CountBalls cb = new CountBalls();
		System.out.println(cb.countBalls(1, 10));
		System.out.println(cb.countBalls(5, 15));
		System.out.println(cb.countBalls(19, 28));
	}
}