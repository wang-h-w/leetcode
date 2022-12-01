import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class FindRightInterval {
	public int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		int[] res = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) map.put(intervals[i][0], i);
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		for (int i = 0; i < n; i++) {
			int idx = search(intervals, intervals[i][1], i, n);
			res[map.get(intervals[i][0])] = idx == -1 ? idx : map.get(intervals[idx][0]);
		}
		return res;
	}

	private int search(int[][] intervals, int target, int left, int right) {
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (intervals[mid][0] < target) left = mid + 1;
			else if (intervals[mid][0] >= target) right = mid;
		}
		return left == intervals.length ? -1 : left;
	}

	public static void main(String[] args) {
		FindRightInterval fri = new FindRightInterval();
		int[] res = fri.findRightInterval(new int[][] {{1,2}});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = fri.findRightInterval(new int[][] {{3,4},{2,3},{1,2}});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = fri.findRightInterval(new int[][] {{1,4},{2,3},{3,4}});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
		res = fri.findRightInterval(new int[][] {{4,5},{2,7},{5,6},{8,8},{7,8},{9,9},{10,11},{6,12}});
		for (int i : res) System.out.print(i + " ");
		System.out.println();
	}
}