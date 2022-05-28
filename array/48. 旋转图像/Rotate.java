class Rotate {
	public void rotate(int[][] matrix) {
		int valueCurr = 0, valueLast = 0, iTemp = 0, jTemp = 0, temp = 0;
		for (int i = 0; i < (matrix.length + 1) / 2; i++) {
			for (int j = i; j < matrix.length - i - 1; j++) {
				iTemp = i;
				jTemp = j;
				valueLast = matrix[iTemp][jTemp];
				for (int k = 0; k < 4; k++) {
					valueCurr = matrix[jTemp][matrix.length-1-iTemp];
					matrix[jTemp][matrix.length-1-iTemp] = valueLast;
					valueLast = valueCurr;
					temp = iTemp;
					iTemp = jTemp;
					jTemp = matrix.length - 1 - temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Rotate r = new Rotate();
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		r.rotate(matrix);
		for (int[] i: matrix) {
			for (int j: i) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}