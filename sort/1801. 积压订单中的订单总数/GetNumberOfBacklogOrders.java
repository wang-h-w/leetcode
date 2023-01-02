import java.util.PriorityQueue;

class GetNumberOfBacklogOrders {
	public int getNumberOfBacklogOrders(int[][] orders) {
		PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		int MOD = 1000000007;
		for (int[] order : orders) {
			if (order[2] == 0) {
				// buy
				while (!sell.isEmpty() && sell.peek()[0] <= order[0] && order[1] > 0) {
					int[] minimumSell = sell.poll();
					order[1] -= minimumSell[1];
					if (order[1] < 0) {
						minimumSell[1] = -order[1];
						sell.offer(minimumSell);
					}
				}
				if (order[1] > 0) buy.offer(order);
			} else {
				// sell
				while (!buy.isEmpty() && buy.peek()[0] >= order[0] && order[1] > 0) {
					int[] maximumBuy = buy.poll();
					order[1] -= maximumBuy[1];
					if (order[1] < 0) {
						maximumBuy[1] = -order[1];
						buy.offer(maximumBuy);
					}
				}
				if (order[1] > 0) sell.offer(order);
			}
		}
		long res = 0;
		while (!buy.isEmpty()) res = (res + buy.poll()[1]) % MOD;
		while (!sell.isEmpty()) res = (res + sell.poll()[1]) % MOD;
		return (int)res;
	}

	public static void main(String[] args) {
		GetNumberOfBacklogOrders backlog = new GetNumberOfBacklogOrders();
		System.out.println(backlog.getNumberOfBacklogOrders(new int[][] {{10,5,0},{15,2,1},{25,1,1},{30,4,0}}));
		System.out.println(backlog.getNumberOfBacklogOrders(new int[][] {{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}}));
	}
}