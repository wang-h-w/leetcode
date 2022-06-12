class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
		if (target == matrix[0][0]) return true;
		// row
		int start = 0, end = m - 1;
		while (start < end) {
			int middle = (start + end) / 2;
			if (matrix[middle][0] == target || matrix[middle+1][0] == target) return true;
			else if (matrix[middle][0] < target && matrix[middle+1][0] > target) {
				start = middle;
				break;
			} else if (matrix[middle][0] > target) end = middle;
			else start = middle + 1;
		}
		// col
		int row = start;
		start = 0;
		end = n - 1;
		while (start < end) {
			int middle = (start + end) / 2;
			if (matrix[row][middle] == target || matrix[row][middle+1] == target) return true;
			else if (matrix[row][middle] < target && matrix[row][middle+1] > target) {
				start = middle;
				break;
			} else if (matrix[row][middle] > target) end = middle;
			else start = middle + 1;
		}

		return false;
	}

	public static void main(String[] args) {
		SearchMatrix s = new SearchMatrix();
		int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		matrix = new int[][] {{1}};
		int target = 1;
		System.out.println(s.searchMatrix(matrix, target));
	}
}