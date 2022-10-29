import java.util.Arrays;
import java.util.LinkedList;

class ReconstructQueue {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (n1, n2) -> {
			if (n1[0] != n2[0]) return n1[0] - n2[0];
			else return n2[1] - n1[1];
		});
		int[][] res = new int[people.length][2];
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < people.length; i++) list.add(i);
		for (int[] p : people) {
			int idx = list.get(p[1]);
			res[idx][0] = p[0];
			res[idx][1] = p[1];
			list.remove(p[1]);
		}
		return res;
	}

	public static void main(String[] args) {
		ReconstructQueue rq = new ReconstructQueue();
		int[][] res = rq.reconstructQueue(new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
		for (int[] i : res) System.out.print("(" + i[0] + "," + i[1] + ") ");
		System.out.println();
		res = rq.reconstructQueue(new int[][] {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}});
		for (int[] i : res) System.out.print("(" + i[0] + "," + i[1] + ") ");
		System.out.println();
	}
}