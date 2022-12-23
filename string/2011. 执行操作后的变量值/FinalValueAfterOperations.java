class FinalValueAfterOperations {
	public int finalValueAfterOperations(String[] operations) {
		int res = 0;
		for (String s : operations) {
			for (int i = 0; i < 3; i++) {
				if (s.charAt(i) == '-') { res--; break; }
				else if (s.charAt(i) == '+') { res++; break; }
			}
		}
		return res;
	}
}