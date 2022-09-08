class GetSum {
	public int getSum(int a, int b) {
		int ans = 0, carry = 0;
		for (int i = 0; i < 32; i++) {
			int bit1 = (a >> i) & 1, bit2 = (b >> i) & 1;
			if (bit1 == 1 && bit2 == 1) {
				ans |= (carry << i);
				carry = 1;
			} else if (bit1 == 1 || bit2 == 1) {
				ans |= (1 ^ carry) << i;
			} else {
				ans |= (carry << i);
				carry = 0;
			}
		}
		return ans;
	}
}