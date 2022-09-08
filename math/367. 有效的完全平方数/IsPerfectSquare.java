class IsPerfectSquare {
	public boolean isPerfectSquare(int num) {
		long start = 1, end = num;
		while (start < end) {
			long mid = start + (end - start) / 2; // left
			long mul = mid * mid;
			if (mul == num) return true;
			else if (mul < num) start = mid + 1;
			else end = mid;
		}
		
		return start * start == num;
	}
}