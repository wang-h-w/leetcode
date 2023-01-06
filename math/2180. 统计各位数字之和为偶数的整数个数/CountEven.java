class CountEven {
	public int countEven(int num) {
		int res = 0;
		for (int i = 1; i <= num; i++) {
			int sum = 0, temp = i;
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}
			if ((sum & 1) == 0) res++;
		}
		return res;
	}
}