class CorpFlightBookings {
	public int[] corpFlightBookings(int[][] bookings, int n) {
		// 差分数组
		int[] diff = new int[n]; // 默认都是零
		for (int[] booking : bookings) {
			diff[booking[0] - 1] += booking[2];
			if (booking[1] < n) diff[booking[1]] -= booking[2];
		}
		// 恢复原数组
		int[] b = new int[n];
		b[0] = diff[0];
		for (int i = 1; i < n; i++) b[i] = b[i - 1] + diff[i];
		return b;
	}
}