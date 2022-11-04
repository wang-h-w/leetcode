class ReachNumber {
	public int reachNumber(int target) {
		target = Math.abs(target);
		int s = 0, n = 0;
		while (s < target || (s - target) % 2 == 1) s += ++n;
		return n;
	}
}