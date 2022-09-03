import java.util.Arrays;
import java.util.Comparator;

class FindLongestChain {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, new Comparator<int[]>() {
			// 加大括号后直接实现接口
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}
		});

		int leftMax = Integer.MAX_VALUE, max = 0;
		for (int i = pairs.length - 1; i >= 0; i--) {
			if (pairs[i][1] < leftMax) {
				leftMax = pairs[i][0];
				max++;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		FindLongestChain find = new FindLongestChain();
		System.out.println(find.findLongestChain(new int[][] {{2,3},{3,4},{1,2}}));
		System.out.println(find.findLongestChain(new int[][] {{1,2}}));
		System.out.println(find.findLongestChain(new int[][] {{2,3},{2,9},{3,5},{4,5},{6,8},{8,9},{9,10}}));
	}
}