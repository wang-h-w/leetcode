class CountBits {
	public int[] countBits(int n) {
		int[] res = new int[n+1];
		res[0] = 0;
		int square = 1, idx = 1;
		for (int i = 1; i <= n; i++) {
			if (i == square) {
				square *= 2;
				idx = 1;
				res[i] = 1;
			} else {
				res[i] = res[idx++] + 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		CountBits cb = new CountBits();
		int[] res = cb.countBits(2);
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = cb.countBits(20);
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}