class IsBipartite {
	private boolean[] visited;
	private boolean[] color;

	public boolean isBipartite(int[][] graph) {
		boolean res = true;
		visited = new boolean[graph.length];
		color = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i]) res &= traverse(graph, i);
		}
		return res;
	}

	private boolean traverse(int[][] graph, int node) {
		visited[node] = true;
		for (int subnode : graph[node]) {
			if (!visited[subnode]) {
				color[subnode] = !color[node];
				if (!traverse(graph, subnode)) return false;
			} else {
				if (color[subnode] == color[node]) return false;
			}
		}
		return true;
	}
}