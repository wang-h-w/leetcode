class EquationPossible {
	public boolean equationsPossible(String[] equations) {
		QuickUnion qu = new QuickUnion(26);
		for (String s : equations) {
			char[] ch = s.toCharArray();
			if (ch[1] == '=') qu.union(ch[0] - 'a', ch[3] - 'a');
		}
		for (String s : equations) {
			char[] ch = s.toCharArray();
			if (ch[1] == '!' && qu.isConnected(ch[0] - 'a', ch[3] - 'a')) return false;
		}
		return true;
	}

	static class QuickUnion {
		private int[] parent;
		private int size;

		public QuickUnion(int n) {
			parent = new int[n];
			size = n;
			for (int i = 0; i < n; i++) parent[i] = i;
		}

		public int find(int x) {
			if (parent[x] != x) parent[x] = find(parent[x]);
			return parent[x];
		}

		public void union(int a, int b) {
			int rootA = find(a), rootB = find(b);
			if (rootA == rootB) return;
			parent[rootA] = rootB;
			size--;
		}

		public boolean isConnected(int a, int b) {
			return find(a) == find(b);
		}
	}
}