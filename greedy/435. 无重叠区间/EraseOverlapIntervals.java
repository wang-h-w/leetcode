class EraseOverlapIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		// sort: end time small to large, start time large to small
		Arrays.sort(intervals, (a, b) -> {
			if (a[1] != b[1]) return a[1] - b[1];
			else return b[0] - a[0];
		});
		// greedy search
		int erase = 0, cmpr = 0;
		for (int i = 1; i < intervals.length; i++) {
			while (i < intervals.length && intervals[i][1] == intervals[i-1][1]) {
				erase++; i++;
			}
			if (i >= intervals.length) break;
			if (intervals[i][0] < intervals[cmpr][1]) erase++;
			else cmpr = i;
		}
		return erase;
	}
}