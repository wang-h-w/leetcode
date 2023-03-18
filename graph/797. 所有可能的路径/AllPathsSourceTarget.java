class AllPathsSourceTarget {
	private List<List<Integer>> res;
	private LinkedList<Integer> path;

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		res = new LinkedList<>();
		path = new LinkedList<>();
		traverse(graph, 0);
		return res;
	}

	private void traverse(int[][] graph, int prev) {
		int n = graph.length;
		path.add(prev);
		if (prev == n - 1) res.add(new LinkedList<>(path));
		for (int next : graph[prev]) traverse(graph, next);
		path.removeLast();
	}
}