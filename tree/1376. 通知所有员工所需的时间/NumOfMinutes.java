class NumOfMinutes {
	static class Node {
		private int time;
		private List<Node> next;

		public Node(int time) {
			this.time = time;
			this.next = new LinkedList<>();
		}
	}

	public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
		Map<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < n; i++) map.put(i, new Node(informTime[i]));
		for (int i = 0; i < n; i++) {
			if (manager[i] != -1) map.get(manager[i]).next.add(map.get(i));
		}
		return depth(map.get(headId));
	}

	private int depth(Node root) {
		if (root == null) return 0;
		int d = Integer.MIN_VALUE;
		for (Node node : root.next) {
			d = Math.max(d, depth(node));
		}
		return d == Integer.MIN_VALUE ? root.time : root.time + d;
	}
}