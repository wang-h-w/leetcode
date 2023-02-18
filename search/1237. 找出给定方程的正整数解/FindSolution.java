class FindSolution {
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> ret = new LinkedList<>();
		for (int x = 1; x <= 1000; x++) {
			// 二分查找y
			int l = 1, r = 1001;
			while (l < r) {
				int y = (l + r) / 2;
				if (customfunction.f(x, y) == z) {
					List<Integer> res = new LinkedList<>();
					res.add(x); res.add(y);
					ret.add(res);
				} else if (customfunction.f(x, y) < z) {
					l = y + 1;
				} else {
					r = y;
				}
			}
		}
		return ret;
	}
}