import java.util.ArrayList;

class Insert {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;

        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        while (i < len && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		Insert i = new Insert();
		int[][] intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[][] result = i.insert(intervals, new int[] {4,8});
		for (int[] j: result) {
			for (int k: j) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}