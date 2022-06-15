class Exist {
	private boolean ret;

	public boolean exist(char[][] board, String word) {
		if (board == null) return false;
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		ret = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				backtrack(board, word, visited, i, j, 0);
				if (ret) return ret;
			}
		}

		return ret;
	}

	private void backtrack(char[][] board, String word, boolean[][] visited, int x, int y, int curr) {
		if (curr == word.length() - 1 && board[x][y] == word.charAt(curr)) { ret = true; return; }
		if (board[x][y] != word.charAt(curr)) return;
		visited[x][y] = true;
		if (!ret && y > 0 && !visited[x][y-1]) backtrack(board, word, visited, x, y - 1, curr + 1);
		if (!ret && y < board[0].length-1 && !visited[x][y+1]) backtrack(board, word, visited, x, y + 1, curr + 1);
		if (!ret && x > 0 && !visited[x-1][y]) backtrack(board, word, visited, x - 1, y, curr + 1);
		if (!ret && x < board.length-1 && !visited[x+1][y]) backtrack(board, word, visited, x + 1, y, curr + 1);
		visited[x][y] = false;
	}

	public static void main(String[] args) {
		Exist e = new Exist();
		char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(e.exist(board, "ABCCED"));
		System.out.println(e.exist(board, "SEE"));
		System.out.println(e.exist(board, "ABCB"));
		System.out.println(e.exist(board, "FCEDASB"));
		board = new char[][] {{'a'}};
		System.out.println(e.exist(board, "a"));
	}
}