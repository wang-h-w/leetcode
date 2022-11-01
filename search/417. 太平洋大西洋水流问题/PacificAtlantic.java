import java.util.List;
import java.util.LinkedList;

class PacificAtlantic {
	private int m = 0, n = 0;
	private int[][] cnt;
	private boolean[][] visited;

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		m = heights.length;
		n = heights[0].length;
		cnt = new int[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) if (!visited[i][0]) dfs(heights, i, 0);
		for (int i = 0; i < n; i++) if (!visited[0][i]) dfs(heights, 0, i);
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) if (!visited[i][n-1]) dfs(heights, i, n-1);
		for (int i = 0; i < n; i++) if (!visited[m-1][i]) dfs(heights, m-1, i);

		List<List<Integer>> ret = new LinkedList<>();
		LinkedList<Integer> path = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (cnt[i][j] == 2) {
					path = new LinkedList<>();
					path.add(i);
					path.add(j);
					ret.add(path);
				}
			}
		}
		return ret;
	}

	private void dfs(int[][] heights, int i, int j) {
		cnt[i][j]++;
		visited[i][j] = true;
		if (i > 0 && !visited[i-1][j] && heights[i-1][j] >= heights[i][j]) dfs(heights, i - 1, j);
		if (i < m - 1 && !visited[i+1][j] && heights[i+1][j] >= heights[i][j]) dfs(heights, i + 1, j);
		if (j > 0 && !visited[i][j-1] && heights[i][j-1] >= heights[i][j]) dfs(heights, i, j - 1);
		if (j < n - 1 && !visited[i][j+1] && heights[i][j+1] >= heights[i][j]) dfs(heights, i, j + 1);
	}

	public static void main(String[] args) {
		PacificAtlantic pa = new PacificAtlantic();
		System.out.println(pa.pacificAtlantic(new int[][] {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}}));
		System.out.println(pa.pacificAtlantic(new int[][] {{2,1},{1,2}}));
		System.out.println(pa.pacificAtlantic(new int[][] {{3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}}));
	}
}