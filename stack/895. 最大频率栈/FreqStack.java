class FreqStack {
	private Map<Integer, List<Integer>> map;
	private Map<Integer, Integer> cnts;
	private int max;
	
	public FreqStack() {
		map = new HashMap<>();
		cnts = new HashMap<>();
		max = 0;
	}
	
	public void push(int val) {
		cnts.put(val, cnts.getOrDefault(val, 0) + 1);
		int c = cnts.get(val);
		List<Integer> list = map.getOrDefault(c, new LinkedList<>());
		list.add(val);
		map.put(c, list);
		max = Math.max(max, c);
	}
	
	public int pop() {
		List<Integer> list = map.get(max);
		int ans = list.remove(list.size() - 1);
		cnts.put(ans, cnts.get(ans) - 1);
		if (list.size() == 0) max--;
		return ans;
	}
}