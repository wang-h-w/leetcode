class MinimumMoves {
	public int minimumMoves(String s) {
		int res = 0, p = 0;
		while (p < s.length()) {
			if (s.charAt(p) == 'X') {
				res++; p += 3;
			} else p++;
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumMoves mm = new MinimumMoves();
		System.out.println(mm.minimumMoves("XXX"));
		System.out.println(mm.minimumMoves("XXOX"));
		System.out.println(mm.minimumMoves("OOOO"));
		System.out.println(mm.minimumMoves("XXXXX"));
	}
}