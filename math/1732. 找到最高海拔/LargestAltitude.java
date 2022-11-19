class LargestAltitude {
	public int largestAltitude(int[] gain) {
		int max = 0, curr = 0;
		for (int h : gain) {
			curr += h;
			max = Math.max(max, curr);
		}
		return max;
	}
}