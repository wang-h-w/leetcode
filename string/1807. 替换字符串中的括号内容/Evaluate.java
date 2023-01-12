class Evaluate {
	public String evaluate(String s, List<List<String>> knowledge) {
		Map<String, String> map = new HashMap<>();
		for (List<String> l : knowledge) map.put(l.get(0), l.get(1));
		StringBuffer sb = new StringBuffer();
		int n = s.length(), l = n - 1, r = n - 1;
		while (r >= 0) {
			char cr = s.charAt(r);
			if (cr == ')') {
				while (l >= 0 && s.charAt(l) != '(') l--;
				String value = map.getOrDefault(s.substring(l + 1, r), "?");
				StringBuffer temp = new StringBuffer(value);
				sb.append(temp.reverse());
				r = l - 1;
				l--;
			} else sb.append(cr);
			r--;
		}
		return sb.reverse().toString();
	}
}