class SetZeroes {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRow = false;
		boolean firstCol = false;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) firstRow = true;
					if (j == 0) firstCol = true;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) matrix[i][j] = 0;
			}
		}
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) matrix[i][j] = 0;
			}
		}

		if (firstRow) for (int j = 1; j < n; j++) matrix[0][j] = 0;
		if (firstCol) for (int i = 1; i < m; i++) matrix[i][0] = 0;
	}

	public static void main(String[] args) {
		SetZeroes s = new SetZeroes();
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		matrix = new int[][] {{1,1,5,3,2,55,3,1,4},{1,1,0,2,43,4,3,0,9},{4,3,3,3,2,2,1,1,1}};
		matrix = new int[][] {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
		s.setZeroes(matrix);
		for (int[] i: matrix) {
			for (int j: i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}