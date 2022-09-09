class GuessNumber extends GuessGame {
	public int guessNumber(int n) {
		if (guess(n) == 0) return n;
		int start = 1, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (guess(mid) == 0) return mid;
			else if (guess(mid) == -1) end = mid;
			else start = mid + 1;
		}
		return 0;
	}
}