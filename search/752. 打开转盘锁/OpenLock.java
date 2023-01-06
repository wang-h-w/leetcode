class OpenLock {
	public int openLock(String[] deadends, String target) {
		Deque<String> dq = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		dq.offer("0000");
        for (String deadend : deadends) visited.add(deadend);
        if (visited.contains("0000")) return -1;
		visited.add("0000");
		int step = 0;

		while (!dq.isEmpty()) {
			int size = dq.size();
			while (size-- > 0) {
				String s = dq.poll();
				if (s.equals(target)) return step;
				for (int i = 0; i < 4; i++) {
					String p = plusOne(s, i);
					if (!visited.contains(p)) {
						dq.offer(p);
						visited.add(p);
					}
					String m = minusOne(s, i);
					if (!visited.contains(m)) {
						dq.offer(m);
						visited.add(m);
					}
				}
			}
			step++;
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