class ArrangeCoins {
	public int arrangeCoins(int n) {
		int left = 1, right = n; // 左闭右开
		while (left < right) {
			int mid = left + (right - left) / 2;
			long sum = mid * 1L * (1 + mid) / 2;
			if (sum > n) right = mid;
			else if (sum <= n) left = mid + 1; 
		}
		return left == 1 ? 1 : left - 1;
	}
}