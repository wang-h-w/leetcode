class AreNumbersAscending {
	public boolean areNumbersAscending(String s) {
		String[] ss = s.split(" ");
		int prev = -1;
		for (String elt : ss) {
			if ('0' <= elt.charAt(0) && elt.charAt(0) <= '9') {
				int res = 0;
				for (int i = 0; i < elt.length(); i++) {
					res *= 10;
					res += elt.charAt(i) - '0';
				}
				if (res <= prev) return false;
				prev = res;
			}
		}
		return true;
	}
}