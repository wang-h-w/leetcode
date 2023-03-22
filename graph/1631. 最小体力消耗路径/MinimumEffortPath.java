class MinimumEffortPath {
	int m, n;

	public int minimumEffortPath(int[][] heights) {
		m = heights.length; n = heights[0].length;
		int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		List<int[]>[] graph = new LinkedList[m * n];
		for (int i = 0; i < m * n; i++) graph[i] = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int[] k : dirs) {
					int x = i + k[0], y = j + k[1];
					if (x >= m || x < 0 || y >= n || y < 0) continue;
					graph[gridToNum(i, j)].add(new int[] {gridToNum(x, y), Math.abs(heights[i][j] - heights[x][y])});
				}
			}
		}
		int[] distTo = dijkstra(gridToNum(0, 0), gridToNum(m - 1, n - 1), graph);
		return distTo[gridToNum(m - 1, n - 1)];
	}

	private int gridToNum(int x, int y) {
		return x * n + y;
	}

	private int[] dijkstra(int start, int end, List<int[]>[] graph) {
		int n = graph.length;
		int[] distTo = new int[n];
		Arrays.fill(distTo, Integer.MAX_VALUE);
		distTo[start] = 0;
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (curr[0] == end) break;
			if (curr[1] > distTo[curr[0]]) continue;
			for (int[] neighbor : graph[curr[0]]) {
				int next = neighbor[0], d = Math.max(distTo[curr[0]], neighbor[1]);
				if (distTo[next] > d) {
					distTo[next] = d;
					pq.offer(new int[] {next, d});
				}
			}
		}
		return distTo;
	}
}