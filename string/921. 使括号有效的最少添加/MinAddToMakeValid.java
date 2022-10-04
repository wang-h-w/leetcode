class MinAddToMakeValid {
	public int minAddToMakeValid(String s) {
		int cntLeft = 0, cntRight = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') cntLeft++;
			else {
				if (cntLeft != 0) cntLeft--;
				else cntRight++;
			}
		}
		return cntLeft + cntRight;
	}

	public static void main(String[] args) {
		MinAddToMakeValid min = new MinAddToMakeValid();
		System.out.println(min.minAddToMakeValid("())"));
		System.out.println(min.minAddToMakeValid("))))(((("));
	}
}