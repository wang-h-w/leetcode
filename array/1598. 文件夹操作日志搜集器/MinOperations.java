class MinOperations {
	public int minOperations(String[] logs) {
		int res = 0;
		for (String s : logs) {
			if (s.equals("./") || (s.equals("../") && res == 0)) continue;
			else if (s.equals("../")) res--;
			else res++;
		}

		return res;
	}

	public static void main(String[] args) {
		MinOperations mo = new MinOperations();
		System.out.println(mo.minOperations(new String[] {"d1/","d2/","../","d21/","./"}));
		System.out.println(mo.minOperations(new String[] {"d1/","d2/","./","d3/","../","d31/"}));
		System.out.println(mo.minOperations(new String[] {"d1/","../","../","../"}));
		System.out.println(mo.minOperations(new String[] {"./","../","./"}));
	}
}