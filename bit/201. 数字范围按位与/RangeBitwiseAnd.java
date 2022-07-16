class RangeBitwiseAnd {
	public int rangeBitwiseAnd(int left, int right) {
		int mask = 1 << 30;
		int ans = 0;
		while (mask > 0 && (left & mask) == (right & mask)) {
			ans |= left & mask;
			mask >>= 1;
		}

		return ans;
	}

	public static void main(String[] args) {
		RangeBitwiseAnd r = new RangeBitwiseAnd();
		System.out.println(r.rangeBitwiseAnd(5, 7));
		System.out.println(r.rangeBitwiseAnd(0, 0));
		System.out.println(r.rangeBitwiseAnd(1, 2147483647));
	}
}