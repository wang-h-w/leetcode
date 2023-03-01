class LargestLocal {
	public int[][] largestLocal(int[][] grid) {
		int n = grid.length, m = n - 2;
		int[][] res = new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				int max = Integer.MIN_VALUE;
				for (int a = i; a <= i + 2; a++) {
					for (int b = j; b <= j + 2; b++) {
						max = Math.max(max, grid[a][b]);
					}
				}
				res[i][j] = max;
			}
		}
		return res;
	}
}