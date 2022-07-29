import java.util.Arrays;

class HIndex {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int n = citations.length;
		for (int i = 0, h = n; i < n; i++, h--) {
			if (citations[i] >= h) return h;
		}
		return 0;
	}

	public static void main(String[] args) {
		HIndex h = new HIndex();
		System.out.println(h.hIndex(new int[] {3,0,6,1,5}));
		System.out.println(h.hIndex(new int[] {1,3,1}));
	}
}