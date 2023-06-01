class MaximumTastiness {
	public int maximumTastiness(int[] price, int k) {
		Arrays.sort(price);
		int n = price.length, l = 0, r = price[n - 1] - price[0] + 1, res = 0;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (check(price, k, mid)) {
				res = mid;
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return res;
	}

	private boolean check(int[] price, int k, int mid) {
		int cnt = 1, prev = price[0];
		for (int i = 0; i < price.length; i++) {
			if (price[i] - prev >= mid) {
				cnt++;
				prev = price[i];
			}
		}
		return cnt >= k;
	}
}