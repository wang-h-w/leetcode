class HIndex {
	public int hIndex(int[] citations) {
		int n = citations.length, start = 0, end = n - 1;
		int res = citations[0] == 0 ? 0 : 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] >= n - mid) {
				end = mid;
				res = n - mid;
			}
			else start = mid + 1;
		}
		return citations[end] >= n - end ? n - end : res;
	}

	public static void main(String[] args) {
		HIndex h = new HIndex();
		System.out.println(h.hIndex(new int[] {0,4,4,5,6}));
		System.out.println(h.hIndex(new int[] {1,2,100}));
		System.out.println(h.hIndex(new int[] {2,2}));
	}
}