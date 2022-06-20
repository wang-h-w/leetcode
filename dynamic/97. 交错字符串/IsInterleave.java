class IsInterleave {
	public boolean isInterleave(String s1, String s2, String s3) {
		// 二维数组记录历史信息：(i,j)为s1到第i-1个字母为止的字符串与s2到第j-1个字母为止的字符串
		// 可否组成s3到第i+j-1个字母为止的字符串
		int m = s1.length(), n = s2.length();
		if (m + n != s3.length()) return false;
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		for (int i = 1; i < m + 1; i++) {
			dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0] ? true : false;
		}
		for (int j = 1; j < n + 1; j++) {
			dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1] ? true : false;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s3.charAt(i+j-1) == s1.charAt(i-1) && dp[i-1][j] || s3.charAt(i+j-1) == s2.charAt(j-1) && dp[i][j-1]) {
					dp[i][j] = true;
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		IsInterleave inter = new IsInterleave();
		System.out.println(inter.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(inter.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(inter.isInterleave("ab", "bc", "babc"));
		System.out.println(inter.isInterleave("ab", "bc", "bbac"));
	}
}