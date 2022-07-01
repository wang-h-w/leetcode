class Solve {
	int col;
	public void solve(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		col = n;
		QuickUnion qu = new QuickUnion(m * n + 1);
		int edge = m * n;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
						qu.connect(arrayToInt(i, j), edge);
					} 
					if (j < n - 1 && board[i][j+1] == 'O') qu.connect(arrayToInt(i, j), arrayToInt(i, j+1));
					if (i < m - 1 && board[i+1][j] == 'O') qu.connect(arrayToInt(i, j), arrayToInt(i+1, j));
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O' && !qu.isConnected(arrayToInt(i, j), edge)) board[i][j] = 'X';
			}
		}
	}

	private int arrayToInt(int i, int j) {
		return i * col + j;
	}

	public static void main(String[] args) {
		Solve s = new Solve();
		char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		board = new char[][] {{'X'}};
		s.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class QuickUnion {
	private int[] parent;
	private int[] size;

	public QuickUnion(int capacity) {
		this.parent = new int[capacity];
		this.size = new int[capacity];
		for (int i = 0; i < capacity; i++) {
			this.parent[i] = i;
			this.size[i] = 1;
		}
	}

	public void connect(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) return;
		if (size[rootA] < size[rootB]) {
			parent[rootA] = rootB;
			size[rootB] += size[rootA];
		} else {
			parent[rootB] = rootA;
			size[rootA] += size[rootB];
		}
	}

	public boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}

	private int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
}