import java.util.PriorityQueue;

class KthSmallest {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				pq.offer(matrix[i][j]);
				if (pq.size() > k) pq.poll();
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		KthSmallest k = new KthSmallest();
		
	}
}