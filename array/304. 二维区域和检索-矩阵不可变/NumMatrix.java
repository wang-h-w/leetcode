class NumMatrix {
	int[][] sum;
	public NumMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		sum = new int[m+1][n+1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + matrix[i][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
		NumMatrix obj = new NumMatrix(matrix);
		System.out.println(obj.sumRegion(2,1,4,3));
		System.out.println(obj.sumRegion(1,1,2,2));
		System.out.println(obj.sumRegion(1,2,2,4));
		System.out.println(obj.sumRegion(0,0,0,2));
	}
}