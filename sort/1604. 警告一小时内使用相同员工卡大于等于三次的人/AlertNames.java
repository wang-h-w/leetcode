class AlertNames {
	public List<String> alertNames(String[] keyName, String[] keyTime) {
		List<String> res = new LinkedList<>();
		Map<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < keyName.length; i++) {
			String name = keyName[i];
			String[] times = keyTime[i].split(":");
			int time = Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
			if (!map.containsKey(name)) map.put(name, new LinkedList<>());
			map.get(name).add(time);
		}

		for (String name : map.keySet()) {
			List<Integer> times = map.get(name);
			times.sort((o1, o2) -> o1 - o2);
			for (int i = 2; i < times.size(); i++) {
				if (times.get(i) - times.get(i - 2) <= 60) {
					res.add(name);
					break;
				}
			}
		}

		res.sort((o1, o2) -> o1.compareTo(o2));
		return res;
	}
}