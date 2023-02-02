class ShortestAlternatingPaths {
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		List<Integer>[] redList = new List[n], blueList = new List[n];
		for (int i = 0; i < n; i++) {
			redList[i] = new ArrayList<>();
			blueList[i] = new ArrayList<>();
		}
		for (int[] e : redEdges) redList[e[0]].add(e[1]);
		for (int[] e : blueEdges) blueList[e[0]].add(e[1]);
		int[] redAns = new int[n], blueAns = new int[n];
		for (int i = 1; i < n; i++) {
			redAns[i] = Integer.MAX_VALUE;
			blueAns[i] = Integer.MAX_VALUE;
		}

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0});
		queue.add(new int[] {0, 1});
		int level = 0;

		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] currArr = queue.poll();
				int curr = currArr[0];
				if (currArr[1] == 0) {
					// 下一步走红色
					for (int next : redList[curr]) {
						if (level < redAns[next]) {
							redAns[next] = level;
							queue.offer(new int[] {next, 1});
						}
					}
				} else {
					// 下一步走蓝色
					for (int next : blueList[curr]) {
						if (level < blueAns[next]) {
							blueAns[next] = level;
							queue.offer(new int[] {next, 0});
						}
					}
				}
			}
		}

		for (int i = 0; i < redAns.length; i++) {
			if (blueAns[i] < redAns[i]) redAns[i] = blueAns[i];
			else if (redAns[i] == Integer.MAX_VALUE) redAns[i] = -1;
		}

		return redAns;
	}
}