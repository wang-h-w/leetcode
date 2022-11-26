import java.util.*;

// 为什么要用Dijkstra？只关心到所有点的最短路径，如果DFS或BFS会有很多重复，而且经过的细分节点无法确定编号
class ReachableNodes {
	private static final int INF = Integer.MAX_VALUE;
	private Map<Integer, List<Integer[]>> map;
	private boolean[] visited;
	private int[] distTo;

	public int reachableNodes(int[][] edges, int maxMoves, int n) {
		// build graph: adjacent list
		map = new HashMap<>();
		visited = new boolean[n];
		distTo = new int[n];
		Arrays.fill(distTo, INF);
		for (int[] edge : edges) {
			int from = edge[0], to = edge[1], dist = edge[2] + 1;
			if (!map.containsKey(from)) map.put(from, new ArrayList<>());
			if (!map.containsKey(to)) map.put(to, new ArrayList<>());
			map.get(from).add(new Integer[] {to, dist});
			map.get(to).add(new Integer[] {from, dist});
		}
		// use dijstra algorithm
		dijkstra(maxMoves);
		// final calculate
		int res = 0;
		for (int i = 0; i < n; i++) if (distTo[i] <= maxMoves) res++;
		for (int[] edge : edges) {
			int from = edge[0], to = edge[1], dist = edge[2];
			int d1 = Math.max(maxMoves - distTo[from], 0);
            int d2 = Math.max(maxMoves - distTo[to], 0);
            res += Math.min(dist, d1 + d2);
		}
		return res;
	}

	private void dijkstra(int maxMoves) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] {0, 0});
		while (!pq.isEmpty()) {
			int[] center = pq.poll();
			if (!visited[center[0]]) distTo[center[0]] = center[1]; // 这里必须判断一下！
			visited[center[0]] = true;
			if (!map.containsKey(center[0])) continue;
			List<Integer[]> neighbors = map.get(center[0]);
			for (Integer[] neighbor : neighbors) {
				int dist = center[1] + neighbor[1];
				if (!visited[neighbor[0]] && dist <= maxMoves) pq.add(new int[] {neighbor[0], dist});
			}
		}
	}

	public static void main(String[] args) {
		ReachableNodes rn = new ReachableNodes();
		System.out.println(rn.reachableNodes(new int[][] {{0,1,10},{0,2,1},{1,2,2}}, 6, 3));
		System.out.println(rn.reachableNodes(new int[][] {{0,1,4},{1,2,6},{0,2,8},{1,3,1}}, 10, 4));
		System.out.println(rn.reachableNodes(new int[][] {{1,2,4},{1,4,5},{1,3,1},{2,3,4},{3,4,5}}, 17, 5));
		System.out.println(rn.reachableNodes(new int[][] {{1,2,5},{0,3,3},{1,3,2},{2,3,4},{0,4,1}}, 7, 5));
		System.out.println(rn.reachableNodes(new int[][] {{3,4,8},{0,1,3},{1,4,0},{1,2,3},{0,3,2},{0,4,10},{1,3,3},{2,4,3},{2,3,3},{0,2,10}}, 7, 5));
	}
}