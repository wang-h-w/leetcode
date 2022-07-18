import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class CanFinish {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		List<List<Integer>> adjacency = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) adjacency.add(new LinkedList<>());
		for (int[] pre : prerequisites) {
			indegrees[pre[0]]++;
			adjacency.get(pre[1]).add(pre[0]);
		}

		for (int i = 0; i < numCourses; i++)
			if (indegrees[i] == 0) queue.add(i);
		// BFS Topological Sort
		while (!queue.isEmpty()) {
			int pre = queue.poll();
			numCourses--;
			for (int curr : adjacency.get(pre))
				if (--indegrees[curr] == 0) queue.add(curr);
		}

		return numCourses == 0;
	}

	public static void main(String[] args) {
		CanFinish f = new CanFinish();
		System.out.println(f.canFinish(2, new int[][] {{1,0}}));
		System.out.println(f.canFinish(2, new int[][] {{1,0},{0,1}}));
	}
}