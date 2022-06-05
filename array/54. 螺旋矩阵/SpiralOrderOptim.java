import java.util.List;
import java.util.LinkedList;

class SpiralOrder {
	public List<Integer> spiralOrder(int[][] matrix) {
		// 我之前的做法是每换一次方向进入一次循环，其实可以每换四次方向进入一次循环 -> 减少变量
		List<Integer> ret = new LinkedList<>();
		if (matrix == null || matrix.length == 0) return ret;
		int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
		while (true) {
			for (int i = l; i <= r; ++i) ret.add(matrix[u][i]);
			if (++u > d) break;
			for (int i = u; i <= d; ++i) ret.add(matrix[i][r]);
			if (--r < l) break;
			for (int i = r; i >= l; --i) ret.add(matrix[d][i]);
			if (--d < u) break;
			for (int i = d; i >= u; --i) ret.add(matrix[i][l]);
			if (++l > r) break;
		}
		return ret;
	}

	public static void main(String[] args) {
		SpiralOrder so = new SpiralOrder();
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		// matrix = new int[][] {{1,2},{2,3},{3,4}};
		List<Integer> result = so.spiralOrder(matrix);
		System.out.println(result);
	}
}