class HardestWorker {
	public int hardestWorker(int n, int[][] logs) {
		int max = logs[0][1], res = logs[0][0];
		for (int i = 1; i < logs.length; i++) {
			int temp = logs[i][1] - logs[i - 1][1];
			if (temp > max) {
				max = temp;
				res = logs[i][0];
			} else if (temp == max && logs[i][0] < res) {
				res = logs[i][0];
			}
		}
		return res;
	}
}