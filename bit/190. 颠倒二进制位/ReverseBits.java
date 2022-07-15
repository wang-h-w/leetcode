class ReverseBits {
	public int reverseBits(int n) {
		// you need treat n as an unsigned value
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res = (res << 1) | (n & 1);
			n >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(0b00000010100101000001111010011100));
		System.out.println(r.reverseBits(0b11111111111111111111111111111101));
	}
}