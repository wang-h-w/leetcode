import java.util.Arrays;

class MaximumUnits {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
		int res = 0, ptr = 0;
		while (truckSize > 0 && ptr < boxTypes.length) {
			int size = boxTypes[ptr][0], unit = boxTypes[ptr][1];
			res += Math.min(truckSize, size) * unit;
			truckSize -= truckSize >= size ? size : truckSize;
			ptr++;
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