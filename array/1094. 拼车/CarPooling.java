class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		int[] diff = new int[1001];
		for (int[] trip : trips) {
			diff[trip[1]] += trip[0];
			if (trip[2] + 1 < 1001) diff[trip[2]] -= trip[0];
		}
		int prev = 0, curr = 0;
		for (int i = 0; i < diff.length; i++) {
			curr = prev + diff[i];
			if (curr > capacity) return false;
			prev = curr;
		}
		return true;
	}
}