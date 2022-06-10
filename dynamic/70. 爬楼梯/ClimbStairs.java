class ClimbStairs {
	public int climbStairs(int n) {
		// 一维数组记录历史信息：i位置为爬到当前位置的方法总数
		if (n == 1) return 1;
		if (n == 2) return 2;
		int prevTwo = 1;
		int prevOne = 2;
		int curr = 0;
		for (int i = 2; i < n; i++) {
			curr = prevOne + prevTwo;
			prevTwo = prevOne;
			prevOne = curr;
		}
		return curr;
	}

	public static void main(String[] args) {
		ClimbStairs s = new ClimbStairs();
		System.out.println(s.climbStairs(3));
	}
}