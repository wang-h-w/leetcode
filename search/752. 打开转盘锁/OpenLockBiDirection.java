class OpenLock {
	public int openLock(String[] deadends, String target) {
		Set<String> visited = new HashSet<>();
        for (String deadend : deadends) visited.add(deadend);
        Set<String> q1 = new HashSet<>(), q2 = new HashSet<>();
		int step = 0;
		q1.add("0000");
		q2.add(target);

		while (!q1.isEmpty() && !q2.isEmpty()) {
			Set<String> temp = new HashSet<>(); // 为了保证上一层的全都poll出去
			for (String curr : q1) {
				if (visited.contains(curr)) continue;
				if (q2.contains(curr)) return step;
				visited.add(curr);
				for (int j = 0; j < 4; j++) {
					String p = plusOne(curr, j);
					if (!visited.contains(p)) temp.add(p);
					String m = minusOne(curr, j);
					if (!visited.contains(m)) temp.add(m);
				}
			}
			step++;
			// 交换q1和q2，下一轮扩散q2
			q1 = q2;
			q2 = temp;
		}
		return -1;
	}

	private String plusOne(String s, int idx) {
		char[] c = s.toCharArray();
		if (c[idx] == '9') c[idx] = '0';
		else c[idx]++;
		return new String(c);
	}

	private String minusOne(String s, int idx) {
		char[] c = s.toCharArray();
		if (c[idx] == '0') c[idx] = '9';
		else c[idx]--;
		return new String(c);
	}
}