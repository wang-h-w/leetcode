class GetLucky {
	public int getLucky(String s, int k) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i) - 'a' + 1;
			while (temp != 0) {
				res += temp % 10;
				temp /= 10;
			}
		}
		while (--k > 0) {
			int temp = 0;
			while (res != 0) {
				temp += res % 10;
				res /= 10;
			}
			res = temp;
		}
		return res;
	}
}