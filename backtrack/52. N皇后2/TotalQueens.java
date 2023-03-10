class TotalQueens {
	private boolean[][] grid;
	private int res;

	public int totalNQueens(int n) {
		res = 0;
		grid = new boolean[n][n];
		backtrack(0, n);
		return res;
	}

	private void backtrack(int row, int n) {
		if (row == n) {
			res++;
			return;
		}
		for (int j = 0; j < n; j++) {
			if (!check(row, j)) continue;
			grid[row][j] = true;
			backtrack(row + 1, n);
			grid[row][j] = false;
		}
	}

	private boolean check(int row, int col) {
		// up
		for (int i = 0; i < row; i++) {
			if (grid[i][col]) return false;
		}
		// up-left
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (grid[i][j]) return false;
		}
		// up-right
		for (int i = row - 1, j = col + 1; i >= 0 && j < grid[0].length; i--, j++) {
			if (grid[i][j]) return false;
		}
		return true;
	}
}