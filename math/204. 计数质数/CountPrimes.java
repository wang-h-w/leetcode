class CountPrimes {
	public int countPrimes(int n) {
		int cnt = 0;
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) isPrime[i] = true;
		for (int i = 2; i * i < n; i++) { // 注意这里i只需到根号n即可，因为根号n乘根号n一定超出范围了
			if (!isPrime[i]) continue;
			for (int j = i * i; j < n; j += i) isPrime[j] = false;
		}
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(10));
		System.out.println(cp.countPrimes(0));
		System.out.println(cp.countPrimes(1));
	}
}