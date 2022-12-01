class NearestValidPoint {
	public int nearestValidPoint(int x, int y, int[][] points) {
		int min = Integer.MAX_VALUE, res = -1;
		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];
			if (point[0] != x && point[1] != y) continue;
			if (point[0] == x && point[1] == y) return i;
			int dist = Math.abs(x - point[0]) + Math.abs(y - point[1]);
			if (dist < min) {
				min = dist;
				res = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NearestValidPoint nvp = new NearestValidPoint();
		System.out.println(nvp.nearestValidPoint(3, 4, new int[][] {{1,2},{3,1},{2,4},{2,3},{4,4}}));
		System.out.println(nvp.nearestValidPoint(3, 4, new int[][] {{3,4}}));
		System.out.println(nvp.nearestValidPoint(3, 4, new int[][] {{2,3}}));
	}
}