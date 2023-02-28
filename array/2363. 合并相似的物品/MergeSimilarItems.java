class MergeSimilarItems {
	public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
		int[] cnt = new int[1001];
		for (int[] item : items1) cnt[item[0]] += item[1];
		for (int[] item : items2) cnt[item[0]] += item[1];

		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > 0) {
				List<Integer> list = new LinkedList<>();
				list.add(i);
				list.add(cnt[i]);
				res.add(list);
			}
		}
		return res;
	}
}