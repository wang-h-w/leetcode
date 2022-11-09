class OrderOfLargestPlusSign {
	public int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] left = new int[n][n], right = new int[n][n], up = new int[n][n], down = new int[n][n];
		Set<Integer> set = new HashSet<>();
		for (int[] mine : mines) set.add(encode(mine[0], mine[1]));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					up[i][j] = set.contains(encode(i, j)) ? 0 : 1;
					left[i][j] = set.contains(encode(i, j)) ? 0 : 1;
				}
				if (i > 0) up[i][j] = set.contains(encode(i, j)) ? 0 : up[i-1][j] + 1;
				if (j > 0) left[i][j] = set.contains(encode(i, j)) ? 0 : left[i][j-1] + 1;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == n - 1 || j == n - 1) {
					down[i][j] = set.contains(encode(i, j)) ? 0 : 1;
					right[i][j] = set.contains(encode(i, j)) ? 0 : 1;
				}
				if (i < n - 1) down[i][j] = set.contains(encode(i, j)) ? 0 : down[i+1][j] + 1;
				if (j < n - 1) right[i][j] = set.contains(encode(i, j)) ? 0 : right[i][j+1] + 1;
			}
		}
		int order = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				order = Math.max(order, Math.min(up[i][j], Math.min(down[i][j], Math.min(left[i][j], right[i][j]))));
			}
		}
		return order;
	}

	private int encode(int a, int b) {
		return a * 5000 + b;
	}
}