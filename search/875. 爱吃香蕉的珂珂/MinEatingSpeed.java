class MinEatingSpeed {
	public int minEatingSpeed(int[] piles, int h) {
		int l = 1, r = 0;
		for (int p : piles) r = Math.max(r, p);
		r += 1;
		while (l < r) {
			int mid = l + (r - l) / 2, cnt = 0;
			for (int p : piles) cnt += (int) Math.ceil(p * 1.0 / mid);
			if (cnt <= h) r = mid;
			else l = mid + 1;
		}
		return l;
	}
}