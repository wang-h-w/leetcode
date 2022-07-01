class Solve {
	int row, col;
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
        	return;
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }
        for (int j = 0; j < col; j++){
            dfs(board, 0, j);
            dfs(board, row-1, j);
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j]!='O') return;
        board[i][j] = '-';  // 不会重复搜索，因为已经从O变成-了
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }

	public static void main(String[] args) {
		Solve s = new Solve();
		char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		// board = new char[][] {{'X'}};
		s.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
