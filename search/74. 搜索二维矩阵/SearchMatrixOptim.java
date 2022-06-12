class SearchMatrixOptim {
	public boolean searchMatrix(int[][] matrix, int target) {
		// 关注数组的空间特性，从左下角开始搜索，如果小则右移，如果大则上移
		int rows = matrix.length - 1, columns = 0;
        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            } else if (num > target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
	}

	public static void main(String[] args) {
		SearchMatrixOptim s = new SearchMatrixOptim();
		int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		// matrix = new int[][] {{1}};
		int target = 11;
		System.out.println(s.searchMatrix(matrix, target));
	}
}