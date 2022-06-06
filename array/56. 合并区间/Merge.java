import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Merge {
	public int[][] merge(int[][] intervals) {
		ArrayList<int[]> ret = new ArrayList<>();
		Arrays.sort(intervals, new MergeComparator());
		int[] start = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= start[1]) start[1] = Math.max(start[1], intervals[i][1]);
			else {
				ret.add(start);
				start = intervals[i];
			}
		}
		ret.add(start);
		return ret.toArray(new int[ret.size()][2]);
	}

	class MergeComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] e1, int[] e2) {
			if (e1[0] == e2[0]) return e1[1] - e2[1];
			else return e1[0] - e2[0];
		}
	}

	public static void main(String[] args) {
		Merge m = new Merge();
		int[][] intervals = new int[][] {{1,3},{8,10},{2,6},{15,18}};
		intervals = new int[][] {{1,4},{0,7}};
		int[][] result = m.merge(intervals);
		for (int[] i: result) {
			for (int j: i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}