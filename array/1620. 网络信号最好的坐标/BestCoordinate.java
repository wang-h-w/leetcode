class BestCoordinate {
	public int[] bestCoordinate(int[][] towers, int radius) {
		int[] maxIdx = new int[2];
		int max = Integer.MIN_VALUE;
		int minX = 0, minY = 0, maxX = 0, maxY = 0;
		for (int[] tower : towers) {
			minX = Math.min(minX, tower[0]);
			minY = Math.min(minY, tower[1]);
			maxX = Math.max(maxX, tower[0]);
			maxY = Math.max(maxY, tower[1]);
		}
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				int sum = quality(towers, radius, i, j);
				if (sum > max) {
					maxIdx[0] = i;
					maxIdx[1] = j;
					max = sum;
				}
			}
		}
		return maxIdx;
	}
	
	private int quality(int[][] towers, int radius, int x, int y) {
		int sum = 0;
		for (int[] tower : towers) {
			double d = Math.sqrt(Math.pow(x - tower[0], 2) + Math.pow(y - tower[1], 2));
			if (d > (double)radius) continue;
			sum += (int)Math.floor(tower[2] / (1 + d));
		}
		return sum;
	}
}