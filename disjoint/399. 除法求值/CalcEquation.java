import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class CalcEquation {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Integer> map = new HashMap<>();
		QuickUnion qu = new QuickUnion(2 * equations.size());
		int cnt = 0;
		for (int i = 0; i < equations.size(); i++) {
			List<String> l = equations.get(i);
			String s1 = l.get(0), s2 = l.get(1);
			if (!map.containsKey(s1)) map.put(s1, cnt++);
			if (!map.containsKey(s2)) map.put(s2, cnt++);
			qu.connect(map.get(s1), map.get(s2), values[i]);
		}

		int n = queries.size();
		double[] res = new double[n];
		for (int i = 0; i < n; i++) {
			String var1 = queries.get(i).get(0), var2 = queries.get(i).get(1);
			Integer id1 = map.get(var1), id2 = map.get(var2);
			if (id1 == null || id2 == null) res[i] = -1.0d;
			else res[i] = qu.isConnected(id1, id2);
		}
		return res;
    }
}

class QuickUnion {
	private int[] parent;
	private double[] weight; // 指向父节点的权值

	public QuickUnion(int capacity) {
		this.parent = new int[capacity];
		this.weight = new double[capacity];
		for (int i = 0; i < capacity; i++) {
			this.parent[i] = i;
			this.weight[i] = 1.0d;
		}
	}

	public void connect(int a, int b, double value) {
		int rootA = find(a), rootB = find(b);
		if (rootA == rootB) return;
		parent[rootA] = rootB;
		weight[rootA] = weight[b] * value / weight[a];
	}

	public double isConnected(int a, int b) {
		int rootA = find(a), rootB = find(b);
		if (rootA == rootB) return weight[a] / weight[b];
		else return -1.0d;
	}

	private int find(int x) {
		if (parent[x] != x) {
			int origin = parent[x];
			parent[x] = find(parent[x]);
			weight[x] *= weight[origin];
		}
		return parent[x];
	}
}