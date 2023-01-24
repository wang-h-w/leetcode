class CountPoints {
	public int[] countPoints(int[][] points, int[][] queries) {
		int[] res = new int[queries.length];
		int idx = 0;
		for (int[] query: queries) {
			int sum = 0;
			for (int[] point : points) {
				if (Math.pow(query[0] - point[0], 2) + Math.pow(query[1] - point[1], 2) <= Math.pow(query[2], 2)) {
					sum++;
				}
			}
			res[idx++] = sum;
		}
		return res;
	}
}