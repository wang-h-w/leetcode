class CountBits {
	public int[] countBits(int n) {
		int[] res = new int[n+1];
		res[0] = 0;
		for (int i = 1; i <= n; i++) {
			// 奇数一定比最近的偶数（就是前一个数）多1（多在了最后一位）
			if ((i & 1) == 1) res[i] = res[i-1] + 1;
			// 偶数中1的数量一定等于其除以2后那个数的1的数量，因为/2等于右移一位，而偶数最后为0
			else res[i] = res[i/2];
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