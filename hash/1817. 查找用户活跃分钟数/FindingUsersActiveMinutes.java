class FindingUsersActiveMinutes {
	public int[] findingUsersActiveMinutes(int[][] logs, int k) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int[] ret = new int[k];
		for (int[] log : logs) {
			if (!map.containsKey(log[0])) map.put(log[0], new HashSet<>());
			map.get(log[0]).add(log[1]);
		}
		for (int key : map.keySet()) {
			ret[map.get(key).size() - 1]++;
		}
		return ret;
	}
}