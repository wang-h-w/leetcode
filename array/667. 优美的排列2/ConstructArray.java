class ConstructArray {
	public int[] constructArray(int n, int k) {
		int[] ret = new int[n];
		int startAsc = 1, startDesc = 1 + k;
		for (int i = 0; i < 1 + k; i++) {
			if (i % 2 == 0) ret[i] = startAsc++;
			else ret[i] = startDesc--;
		}
		for (int i = 1 + k; i < n; i++) ret[i] = i + 1;
		
		return ret;
	}
}