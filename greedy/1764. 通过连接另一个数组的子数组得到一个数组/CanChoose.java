class CanChoose {
	public boolean canChoose(int[][] groups, int[] nums) {
		int m = groups.length, n = nums.length;
		int p1 = 0, p2 = 0;
		while (p1 < m && p2 < n) {
			if (groups[p1][0] != nums[p2]) { p2++; continue; }
			int t1 = 0, t2 = p2;
			while (t1 < groups[p1].length && t2 < n) {
				if (groups[p1][t1] != nums[t2]) break;
				t1++; t2++;
			}
			if (t1 == groups[p1].length) {
				p1++;
				p2 = t2;
			} else p2++;
		}
		return p1 == m;
	}
}