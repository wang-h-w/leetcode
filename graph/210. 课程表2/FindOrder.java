import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class FindOrder {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] ret = new int[numCourses];
		int[] indegrees = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		List<List<Integer>> adjacency = new LinkedList<>();
		int j = 0;

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
			ret[j++] = pre;
			for (int curr : adjacency.get(pre))
				if (--indegrees[curr] == 0) queue.add(curr);
		}

		return j == numCourses ? ret : new int[0];
	}

	public static void main(String[] args) {
		FindOrder f = new FindOrder();
		int[] res = f.findOrder(2, new int[][] {{1,0}});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = f.findOrder(2, new int[][] {{1,0},{0,1}});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = f.findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = f.findOrder(1, new int[][] {});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}