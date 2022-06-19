class NumDecodings {
	public int numDecodings(String s) {
		// 一维数组记录历史信息：第i个元素为到该位置处的解码方法总数
		int len = s.length();
		int[] dp = new int[len];
		dp[0] = Integer.valueOf(s.substring(0, 1)) > 0 ? 1 : 0;
		if (len == 1) return dp[0];
		dp[1] = Integer.valueOf(s.substring(0, 2)) >= 10 && Integer.valueOf(s.substring(0, 2)) <= 26 ? 1 : 0;
		dp[1] += Integer.valueOf(s.substring(1, 2)) > 0 ? dp[0] : 0;
		for (int i = 2; i < len; i++) {
			dp[i] = Integer.valueOf(s.substring(i-1, i+1)) >= 10 && Integer.valueOf(s.substring(i-1, i+1)) <= 26 ? dp[i-2] : 0;
			dp[i] += Integer.valueOf(s.substring(i, i+1)) > 0 ? dp[i-1] : 0;
		}

		return dp[len-1];
	}

	public static void main(String[] args) {
		NumDecodings num = new NumDecodings();
		System.out.println(num.numDecodings("124304"));
	}
}