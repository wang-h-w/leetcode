class CheckArithmeticSubarrays {
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		int n = nums.length, m = l.length;
		List<Boolean> res = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			int len = r[i] - l[i] + 1;
			int[] temp = new int[len];
			System.arraycopy(nums, l[i], temp, 0, len);
			Arrays.sort(temp);
			Boolean flag = true;
			if (len > 1) {
				int diff = temp[1] - temp[0];
				for (int j = 1; j < temp.length; j++) {
					if (temp[j] - temp[j - 1] != diff) flag = false;
				}
			}
			res.add(flag);
		}
		return res;
	}
}