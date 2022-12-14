class DistanceLimitedPathsExist {
	public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		Integer[] qIdx = new Integer[queries.length];
		for (int i = 0; i < queries.length; i++) qIdx[i] = i;
		Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
		Arrays.sort(qIdx, (a, b) -> queries[a][2] - queries[b][2]);
		QuickUnion qu = new QuickUnion(n);
		boolean[] res = new boolean[queries.length];

		int e = 0;
		for (int p : qIdx) {
			int dist = queries[p][2];
			while (e < edgeList.length && edgeList[e][2] < dist) {
				qu.connect(edgeList[e][0], edgeList[e][1]);
				e += 1;
			}
			res[p] = qu.isConnected(queries[p][0], queries[p][1]);
		}
		return res;
	}
}

class QuickUnion {
	private int[] parent;
	private int[] size;

	public QuickUnion(int capacity) {
		this.parent = new int[capacity + 1];
		this.size = new int[capacity + 1];
		for (int i = 0; i < capacity; i++) {
			this.parent[i] = i;
			this.size[i] = 1;
		}
	}

	public void connect(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) return;
		if (size[rootA] < size[rootB]) {
			parent[rootA] = rootB;
			size[rootB] += size[rootA];
		} else {
			parent[rootB] = rootA;
			size[rootA] += size[rootB];
		}
	}

	public boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}

	private int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
}