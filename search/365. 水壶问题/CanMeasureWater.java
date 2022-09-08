class CanMeasureWater {
	public boolean canMeasureWater(int x, int y, int z) {
		// 这类问题一般用BFS做，列举当下所有可能的操作，关键是要定义好变量
		if (z < 0 || z > x + y) return false;
		Set<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		while (!q.isEmpty()) {
			int n = q.poll(); // 把两个水壶中的水量和，看作是一个整体，因此省去了对两个水壶间互相倒水的讨论
			if (n + x <= x + y && set.add(n + x)) {
				q.offer(n + x);
			}
			if (n + y <= x + y && set.add(n + y)) {
				q.offer(n + y);
			}
			if (n - x >= 0 && set.add(n - x)) {
				q.offer(n - x);
			}
			if (n - y >= 0 && set.add(n - y)) {
				q.offer(n - y);
			}
			if (set.contains(z)) {
				return true;
			}
		}
		return false;
	}
}