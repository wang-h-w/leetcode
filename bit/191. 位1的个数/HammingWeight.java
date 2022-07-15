class HammingWeight {
	public int hammingWeight(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += n & 1;
			n >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		HammingWeight h = new HammingWeight();
		System.out.println(h.hammingWeight(0b00000000000000000000000000001011));
		System.out.println(h.hammingWeight(0b00000000000000000000000010000000));
		System.out.println(h.hammingWeight(0b11111111111111111111111111111101));
	}
}