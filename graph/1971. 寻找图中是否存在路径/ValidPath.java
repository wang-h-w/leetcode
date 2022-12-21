class ValidPath {
	private int[] p;

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		p = new int[n];
		for (int i = 0; i < n; i++) p[i] = i;
		for (int[] edge : edges) p[find(edge[0])] = find(edge[1]);
		return find(source) == find(destination);
	}

	private int find(int x) {
		if (p[x] != x) p[x] = find(p[x]);
		return p[x];
	}
}