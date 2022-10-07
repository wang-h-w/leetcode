class FindNthDigit {
	public int findNthDigit(int n) {
		long bit = 1, left = 0, right = 8, len = 9;
		while (n - 1 > right) {
			bit++;
			left = right + 1;
			len = (int) (9 * Math.pow(10, bit - 1) * bit);
			right = left + len - 1;
		}

		long numIdx = (n - 1 - left) / bit, bitIdx = (n - 1 - left) % bit;
		int num = (int) (Math.pow(10, bit - 1) + numIdx);
		int ans = Integer.toString(num).charAt((int)bitIdx) - '0';
		return ans;
	}

	public static void main(String[] args) {
		FindNthDigit find = new FindNthDigit();
		// for (int i = 1; i < 4000; i++) System.out.print(find.findNthDigit(i) + " ");
		System.out.println(find.findNthDigit(1000000000));
	}
}