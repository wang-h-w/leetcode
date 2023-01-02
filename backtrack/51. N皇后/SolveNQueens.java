import java.util.List;
import java.util.LinkedList;

class SolveNQueens {
	private List<List<String>> ret;
	private boolean[][] grid;

	public List<List<String>> solveNQueens(int n) {
		ret = new LinkedList<>();
		grid = new boolean[n][n];
		backtrack(0, n);
		return ret;
	}

	private void backtrack(int row, int n) {
		if (row == n) {
			ret.add(gridToList());
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

	private List<String> gridToList() {
		List<String> res = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) sb.append('Q');
				else sb.append('.');
			}
			res.add(sb.toString());
		}
		return res;
	}

	public static void main(String[] args) {
		SolveNQueens queens = new SolveNQueens();
		System.out.println(queens.solveNQueens(4));
		System.out.println(queens.solveNQueens(1));
	}
}