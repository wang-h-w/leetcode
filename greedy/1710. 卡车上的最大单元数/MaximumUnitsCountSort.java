import java.util.Arrays;

class MaximumUnits {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		int[] memo = new int[1001]; // 最多就1000种
		for (int[] box : boxTypes) memo[box[1]] += box[0]; // 计数排序复杂度为n
		int res = 0;
		for (int i = memo.length - 1; i >= 0; i--) {
			if (memo[i] == 0) continue;
			if (truckSize > memo[i]) {
				res += memo[i] * i;
				truckSize -= memo[i];
			} else return res + truckSize * i;
		}
		return res;
	}

	public static void main(String[] args) {
		MaximumUnits m = new MaximumUnits();
		System.out.println(m.maximumUnits(new int[][] {{1,3},{2,2},{3,1}}, 4));
		System.out.println(m.maximumUnits(new int[][] {{5,10},{2,5},{4,7},{3,9}}, 10));
		System.out.println(m.maximumUnits(new int[][] {{5,10},{2,5},{4,7},{3,9}}, 20));
	}
}