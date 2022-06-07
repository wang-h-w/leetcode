class GenerateMatrix {
	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		int num = 1;
		int u = 0, d = n - 1, l = 0, r = n - 1;
		while (true) {
			for (int i = l; i <= r; i++, num++) ret[u][i] = num;
			if (++u > d) break;
			for (int i = u; i <= d; i++, num++) ret[i][r] = num;
			if (--r < l) break;
			for (int i = r; i >= l; --i, num++) ret[d][i] = num;
			if (--d < u) break;
			for (int i = d; i >= u; --i, num++) ret[i][l] = num;
			if (++l > r) break;
		}
		return ret;
	}

	public static void main(String[] args) {
		GenerateMatrix gm = new GenerateMatrix();
		int[][] result = gm.generateMatrix(6);
		for (int[] i: result) {
			for (int j: i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}