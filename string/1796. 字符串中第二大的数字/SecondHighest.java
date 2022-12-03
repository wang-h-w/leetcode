class SecondHighest {
	public int secondHighest(String s) {
		int highest = -1, second = -1;
		for (int i = 0; i < s.length(); i++) {
			int curr = s.charAt(i) - '0';
			if (0 <= curr && curr <= 9) {
				if (curr > highest) {
					second = highest;
					highest = curr;
				} else if (curr < highest && curr > second) {
					second = curr;
				}
			}
		}
		return second;
	}

	public static void main(String[] args) {
		SecondHighest sh = new SecondHighest();
		System.out.println(sh.secondHighest("dfa12321afd"));
		System.out.println(sh.secondHighest("abc1111"));
		System.out.println(sh.secondHighest("3847128879"));
	}
}