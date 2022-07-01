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