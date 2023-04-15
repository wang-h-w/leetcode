class GardenNoAdj {
	private int[] res;

	public int[] gardenNoAdj(int n, int[][] paths) {
		List<Integer>[] graph = build(n, paths);
		res = new int[n];
		for (int i = 0; i < n; i++) dfs(graph, i);
		return res;
	}

	private void dfs(List<Integer>[] graph, int currId) {
		if (res[currId] != 0) return;
		Set<Integer> nearbyColor = new HashSet<>();
		for (int nearbyId : graph[currId]) {
			if (res[nearbyId] != 0) nearbyColor.add(res[nearbyId]);
		}
		for (int i = 1; i <= 4; i++) {
			if (!nearbyColor.contains(i)) {
				res[currId] = i;
				break;
			}
		}
		for (int nearbyId : graph[currId]) dfs(graph, nearbyId);
	}

	private List<Integer>[] build(int n, int[][] paths) {
		List<Integer>[] graph = new LinkedList[n];
		for (int i = 0; i < n; i++) graph[i] = new LinkedList<>();
		for (int[] path : paths) {
			int from = path[0] - 1, to = path[1] - 1;
			graph[from].add(to);
			graph[to].add(from);
		}
		return graph;
	}
}