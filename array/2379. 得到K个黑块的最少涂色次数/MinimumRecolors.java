class MinimumRecolors {
	public int minimumRecolors(String blocks, int k) {
		int n = blocks.length(), l = 0, r = 0;
		int black = 0, white = Integer.MAX_VALUE;
		while (r < n) {
			char cr = blocks.charAt(r++);
			if (cr == 'B') black++;
			if (r - l >= k) {
				if (black >= k) return 0;
				if (k - black < white) white = k - black;
				char cl = blocks.charAt(l++);
				if (cl == 'B') black--;
			}
		}
		return white;
	}
}