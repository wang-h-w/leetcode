class CamelMatch {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> res = new LinkedList<>();
		for (String query : queries) {
			int q = 0, p = 0;
			boolean flag = true;
			while (q < query.length() && p < pattern.length()) {
				char qq = query.charAt(q), pp = pattern.charAt(p);
				if (qq == pp) {
					q++;
					p++;
				} else if ('A' <= qq && qq <= 'Z') {
					flag = false;
					break;
				} else q++;
			}
			while (q < query.length()) {
				char qq = query.charAt(q++);
				if ('A' <= qq && qq <= 'Z') { flag = false; break; }
			}
			res.add(flag && (p == pattern.length()));
		}
		return res;
	}
}