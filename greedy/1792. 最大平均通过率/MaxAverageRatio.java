import java.util.PriorityQueue;
import java.util.Comparator;

class MaxAverageRatio {
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				double a = (o1[0] + 1) * 1.0 / (o1[1] + 1) - o1[0] * 1.0 / o1[1];
				double b = (o2[0] + 1) * 1.0 / (o2[1] + 1) - o2[0] * 1.0 / o2[1];
				if (a < b) return 1;
				else if (a > b) return -1;
				else return 0;
			}
		});
		for (int[] cls : classes) pq.add(cls);
		while (extraStudents-- > 0) {
			int[] cls = pq.poll();
			cls[0] = cls[0] + 1;
			cls[1] = cls[1] + 1;
			pq.add(cls);
		}
		double res = 0.0;
		while (!pq.isEmpty()) {
			int[] cls = pq.poll();
			res += cls[0] * 1.0 / cls[1];
		}
		return res / classes.length;
	}

	public static void main(String[] args) {
		MaxAverageRatio mar = new MaxAverageRatio();
		System.out.println(mar.maxAverageRatio(new int[][] {{1,2},{3,5},{2,2}}, 2));
	}
}