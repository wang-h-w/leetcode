Class CountAsterisks {
	public int countAsterisks(String s) {
		boolean meet = false;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '|') {
				if (meet) meet = false;
				else meet = true;
			}
			if (!meet && c == '*') res++;
		}
		return res;
	}
}