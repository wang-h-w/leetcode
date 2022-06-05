import java.util.List;
import java.util.LinkedList;

class SpiralOrder {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new LinkedList<>();
		int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1;
		boolean changeRow = false;
		int row = startRow, col = startCol;
		int updateRow = 1, updateCol = 1;

		while (startRow <= endRow && startCol <= endCol) {
			while (row >= startRow && row <= endRow && col >= startCol && col <= endCol) {
				ret.add(matrix[row][col]);
				if (changeRow) row += updateRow;
				else col += updateCol;
			}
			if (changeRow) {
				col -= updateRow;
				if (updateRow > 0) endCol--;
				else startCol++;
				updateRow = -updateRow;
				row += updateRow;
			} else {
				row += updateCol;
				if (updateCol > 0) startRow++;
				else endRow--;
				updateCol = -updateCol;
				col += updateCol;	
			}
			changeRow = !changeRow;
		}
		return ret;
	}

	public static void main(String[] args) {
		SpiralOrder so = new SpiralOrder();
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		matrix = new int[][] {{1,2},{2,3},{3,4}};
		List<Integer> result = so.spiralOrder(matrix);
		System.out.println(result);
	}
}