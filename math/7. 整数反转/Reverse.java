class Reverse {
	public int reverse(int x) {
		int res = 0, origin = x, x = Math.abs(x);
		while (x != 0) {
			int last = x % 10;
			if ((Integer.MAX_VALUE - last) / 10 < res) return 0;
			res = res * 10 + last;
			x /= 10;
		}
		return origin > 0 ? res : -res;
	}
}