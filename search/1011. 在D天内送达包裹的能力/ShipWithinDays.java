class ShipWithinDays {
	public int shipWithinDays(int[] weights, int days) {
		// 二分边界
		int l = 0, r = 1;
		for (int w : weights) {
			l = Math.max(l, w);
			r += w;
		}
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (check(weights, mid, days)) r = mid;
			else l = mid + 1;
		}
		return r;
	}

	private boolean check(int[] weights, int target, int days) {
		int n = weights.length;
		int cnt = 1;
		for (int i = 1, sum = weights[0]; i < n; sum = 0, cnt++) {
			while (i < n && sum + weights[i] <= target) {
				sum += weights[i];
				i++;
			}
		}
		return cnt - 1 <= days;
	}
}