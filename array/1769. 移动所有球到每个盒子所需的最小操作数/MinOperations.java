class MinOperations {
	public int[] minOperations(String boxes) {
		int n = boxes.length(), cnt = boxes.charAt(0) == '0' ? 0 : 1, temp = 0;
		int[] res = new int[n];
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] + cnt;
			cnt = boxes.charAt(i) == '0' ? cnt : cnt + 1;
		}
		cnt = boxes.charAt(n - 1) == '0' ? 0 : 1;
		for (int i = n - 2; i >= 0; i--) {
			temp += cnt;
			cnt = boxes.charAt(i) == '0' ? cnt : cnt + 1;
			res[i] += temp;
		}
		return res;
	}

	public static void main(String[] args) {
		MinOperations mo = new MinOperations();
		int[] res = mo.minOperations("110");
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = mo.minOperations("001011");
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}