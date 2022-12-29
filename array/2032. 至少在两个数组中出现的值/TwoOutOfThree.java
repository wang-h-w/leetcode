class TwoOutOfThree {
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
		List<Integer> res = new LinkedList<>();
		boolean[][] memo = new boolean[110][3];
		for (int i : nums1) memo[i][0] = true;
		for (int i : nums2) memo[i][1] = true;
		for (int i : nums3) memo[i][2] = true;
		for (int i = 0; i < memo.length; i++) {
			int temp = 0;
			for (int j = 0; j < 3; j++) {
				if (memo[i][j]) temp++;
			}
			if (temp >= 2) res.add(i);
		}
		return res;
	}
}