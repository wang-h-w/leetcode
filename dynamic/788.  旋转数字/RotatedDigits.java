class RotatedDigits {
	public int rotatedDigits(int n) {
		int res = 0;
		for (int i = 1; i <= n; i++) {
			char[] charArray = String.valueOf(i).toCharArray();
			int add = 0;
			for (char c : charArray) {
				if (c == '3' || c == '4' || c == '7') {
					add = 0;
					break;
				} else if (c == '2' || c == '5' || c == '6' || c == '9') {
					add = 1;
				}
			}
			res += add;
		}
		return res;
	}
}