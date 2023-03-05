class MinOperationsMaxProfit {
	public int minOperationsMaxProfit(int[] customers, int boardingCost,int runningCost) {
		int currProfit = 0, maxProfit = Integer.MIN_VALUE, wait = 0, times = 0, cnt = 0;
		for (int i = 0; i < customers.length; i++) {
			cnt++;
			wait += customers[i];
			int board = wait >= 4 ? 4 : wait;
			currProfit += board * boardingCost - runningCost;
			if (currProfit > maxProfit) {
				maxProfit = currProfit;
				times = cnt;
			}
			wait -= board;
		}
		while (wait > 0) {
			cnt++;
			int board = wait >= 4 ? 4 : wait;
			currProfit += board * boardingCost - runningCost;
			if (currProfit > maxProfit) {
				maxProfit = currProfit;
				times = cnt;
			}
			wait -= board;
		}
		return maxProfit > 0 ? times : -1;
	}
}