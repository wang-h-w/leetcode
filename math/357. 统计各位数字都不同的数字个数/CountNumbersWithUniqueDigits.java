class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		// 用乘法原理，类似于排列组合
		int res = 1;
        int product = 9;
        for (int i = 1; i < 10 && i <= n; i++) {
            res = product + res;
            product *= (10-i);
        }
        return res;
	}
}