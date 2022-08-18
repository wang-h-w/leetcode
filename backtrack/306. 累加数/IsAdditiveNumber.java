class IsAdditiveNumber {
	private String nums;

	public boolean isAdditiveNumber(String nums) {
		this.nums = nums;
		return dfs(0, 0, 0, 0);
	}

	private boolean dfs(int index, int count, long prevprev, long prev) {
		if (index >= nums.length()) return count > 2;
		long current = 0;
		for (int i = index; i < nums.length(); i++) {
			char c = nums.charAt(i);
			if (nums.charAt(index) == '0' && i > index) return false;
			current = current * 10 + c - '0';
			if (count >= 2) {
				long sum = prevprev + prev;
				if (current > sum) return false;
				if (current < sum) continue;
			}
			if (dfs(i + 1, count + 1, prev, current)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		IsAdditiveNumber a = new IsAdditiveNumber();
		System.out.println(a.isAdditiveNumber("112358"));
		System.out.println(a.isAdditiveNumber("199100199298"));
		System.out.println(a.isAdditiveNumber("199100199"));
	}
}