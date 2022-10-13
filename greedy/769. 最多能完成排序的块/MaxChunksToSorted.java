class MaxChunksToSorted {
	public int maxChunksToSorted(int[] arr) {
		int cnt = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= i && i >= max) {
				cnt++;
				max++;
			}
			else {
				max = Math.max(max, arr[i]);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		MaxChunksToSorted chunks = new MaxChunksToSorted();
		System.out.println(chunks.maxChunksToSorted(new int[] {4,3,2,1,0}));
		System.out.println(chunks.maxChunksToSorted(new int[] {1,0,2,3,4}));
		System.out.println(chunks.maxChunksToSorted(new int[] {0,1,2,3,4,5}));
	}
}