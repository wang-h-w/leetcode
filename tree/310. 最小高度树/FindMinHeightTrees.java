import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class FindMinHeightTrees {
	// 核心思想：越是靠里面的节点越有可能是最小高度树
	// 最外层的节点度为1，去掉后又会暴露新的度为1的节点
	// 最后找到的就是两边同时向中间靠近的节点（相当于把距离二分了）
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) map.add(new ArrayList<>());
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 把所有出度为1的节点，也就是叶子节点入队
        for (int i = 0; i < n; i++) if (degree[i] == 1) queue.offer(i);
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) queue.offer(neighbor);
                }
            }
        }
        return res;
	}

	public static void main(String[] args) {
		FindMinHeightTrees f = new FindMinHeightTrees();
		System.out.println(f.findMinHeightTrees(4, new int[][] {{1,0},{1,2},{1,3}}));
		System.out.println(f.findMinHeightTrees(6, new int[][] {{3,0},{3,1},{3,2},{3,4},{5,4}}));
	}
}