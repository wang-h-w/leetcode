import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class FindOrder {
	private boolean[] visited, onPath;
	private boolean hasCircle = false;
	private List<Integer> postOrder;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = build(prerequisites, numCourses);
		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];
		postOrder = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) traverse(graph, i);
		if (hasCircle) return new int[0];
		Collections.reverse(postOrder);
		int[] res = new int[numCourses];
		for (int i = 0; i < numCourses; i++) res[i] = postOrder.get(i);
		return res;
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
		postOrder.add(s);
		onPath[s] = false;
	}
}