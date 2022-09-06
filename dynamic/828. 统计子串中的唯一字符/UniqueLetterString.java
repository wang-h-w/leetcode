class UniqueLetterString {
	public int uniqueLetterString(String s) {
		int n = s.length(), sum = 1;
		int[] dp = new int[n];
		int[][] count = new int[26][3];
		
		dp[0] = 1;
		count[s.charAt(0) - 'A'][0] = 1;
		
		for (int i = 1; i < n; i++) {
			int pos = s.charAt(i) - 'A';
			if (count[pos][0] == 0) {
				dp[i] = dp[i-1] + i + 1;
				count[pos][1] = 0;
			} else {
				dp[i] = dp[i-1] + 1 + (i - 1 - count[pos][2]) - (count[pos][2] - count[pos][1] + 1);
				count[pos][1] = count[pos][2] + 1;
			}
			sum += dp[i];
			count[pos][0]++;
			count[pos][2] = i;
		}
		
		return sum;
	}
}
