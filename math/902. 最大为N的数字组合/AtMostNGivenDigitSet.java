class AtMostNGivenDigitSet {
	public int atMostNGivenDigitSet(String[] digits, int n) {
		int len = 1, temp = n, res = 0, add = 0, digitsLength = digits.length;
		while (temp / 10 != 0 && len++ >= 1) temp /= 10;
		res += sum(digitsLength, digitsLength, len - 1);

		char[] nChar = Integer.toString(n).toCharArray();
		StringBuffer sb = new StringBuffer();
		for (String s : digits) sb.append(s);
		char[] dChar = sb.toString().toCharArray();

		for (int i = 0; i < len; i++) {
			int ptr = 0;
			while (ptr < digitsLength && dChar[ptr] < nChar[i]) ptr++;
			if (ptr == digitsLength) {
				res += Math.pow(digitsLength, len - i);
				break;
			}
			res += ptr * Math.pow(digitsLength, len - i - 1);
			if (dChar[ptr] > nChar[i]) break;
			if (i == len - 1) res += 1;
		}

		return res;
	}

	private int sum(int a1, int q, int n) {
		if (q == 1) return n * a1;
		return (int) (a1 * (1 - Math.pow(q, n)) / (1 - q));
	}

	public static void main(String[] args) {
		AtMostNGivenDigitSet n = new AtMostNGivenDigitSet();
		System.out.println(n.atMostNGivenDigitSet(new String[] {"1","3","5","7"}, 100));
		System.out.println(n.atMostNGivenDigitSet(new String[] {"1","4","9"}, 1000000000));
		System.out.println(n.atMostNGivenDigitSet(new String[] {"7"}, 8));
		System.out.println(n.atMostNGivenDigitSet(new String[] {"1"}, 834));
		System.out.println(n.atMostNGivenDigitSet(new String[] {"3","4","8"}, 4));
		System.out.println(n.atMostNGivenDigitSet(new String[] {"1","4","9"}, 937282634));
	}
}