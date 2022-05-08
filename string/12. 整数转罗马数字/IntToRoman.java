class IntToRoman {
	public String intToRoman(int num) {
		int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				sb.append(romans[i]);
				num -= values[i];
			}
			if (num == 0) {
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		IntToRoman r = new IntToRoman();
		String result = r.intToRoman(1994);
		System.out.println(result);
	}
}