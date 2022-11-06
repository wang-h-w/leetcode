class CountSegments {
	public int countSegments(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				if (i == 0 || s.charAt(i-1) == ' ') cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		CountSegments cnt = new CountSegments();
		System.out.println(cnt.countSegments("   Hello,  my name   is John"));
	}
}