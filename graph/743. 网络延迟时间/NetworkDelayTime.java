class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int n, int k) {
		List<int[]>[] graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) graph[i] = new LinkedList<>();
		for (int[] edge : times) {
			int from = edge[0], to = edge[1], weight = edge[2];
			graph[from].add(new int[] {to, weight});
		}
		int[] distTo = dijkstra(k, graph);
		int res = 0;
		for (int i = 1; i <= n; i++) {
			if (distTo[i] == Integer.MAX_VALUE) return -1;
			res = Math.max(res, distTo[i]);
		}
		return res;
	}

	private int[] dijkstra(int start, List<int[]>[] graph) {
		int n = graph.length;
		int[] distTo = new int[n];
		Arrays.fill(distTo, Integer.MAX_VALUE);
		distTo[start] = 0;
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (curr[1] > distTo[curr[0]]) continue;
			for (int[] neighbor : graph[curr[0]]) {
				int next = neighbor[0], d = distTo[curr[0]] + neighbor[1];
				if (distTo[next] > d) {
					distTo[next] = d;
					pq.offer(new int[] {next, d});
				}
			}
		}
		return distTo;
	}
}