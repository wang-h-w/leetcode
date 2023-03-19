class CanFinish {
	private boolean[] visited;
	private boolean[] onPath;
	private boolean hasCircle = false;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = build(prerequisites, numCourses);
		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) traverse(graph, i);
		return !hasCircle;
	}

	private List<Integer>[] build(int[][] prerequisites, int n) {
		List<Integer>[] graph = new LinkedList[n];
		for (int i = 0; i < n; i++) graph[i] = new LinkedList<>();
		for (int[] pre : prerequisites) graph[pre[1]].add(pre[0]);
		return graph;
	}

	private void traverse(List<Integer>[] graph, int s) {
		if (onPath[s]) hasCircle = true;
		if (onPath[s] || visited[s]) return;
		visited[s] = true;
		onPath[s] = true;
		for (int t : graph[s]) traverse(graph, t);
		onPath[s] = false;
	}
}