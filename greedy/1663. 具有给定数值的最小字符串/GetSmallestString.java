class GetSmallestString {
	public String getSmallestString(int n, int k) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			int c = k - (n - i);
			if (c < 26) {
				sb.append((char)('a' - 1 + c));
				k -= c;
			} else {
				sb.append('z');
				k -= 26;
			}
		}
		return sb.reverse().toString();
	}
}