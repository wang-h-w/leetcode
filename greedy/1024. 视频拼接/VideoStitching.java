class VideoStitching {
	public int videoStitching(int[][] clips, int time) {
		int n = clips.length, i = 0;
		Arrays.sort(clips, (a, b) -> {
			if (a[0] == b[0]) return b[1] - a[1];
			else return a[0] - b[0];
		});
		int res = 0, currEnd = 0, nextEnd = 0;
		while (i < n && clips[i][0] <= currEnd) {
			while (i < n && clips[i][0] <= currEnd) {
				nextEnd = Math.max(nextEnd, clips[i++][1]);
			}
			res++;
			currEnd = nextEnd;
			if (currEnd >= time) return res;
		}
		return -1;
	}
}