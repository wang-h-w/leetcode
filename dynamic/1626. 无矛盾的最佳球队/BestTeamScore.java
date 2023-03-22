class BestTeamScore {
	public int bestTeamScore(int[] scores, int[] ages) {
		int n = scores.length;
		int[][] team = new int[n][2];
		for (int i = 0; i < n; i++) {
			team[i][0] = ages[i];
			team[i][1] = scores[i];
		}
		Arrays.sort(team, (a, b) -> {
			if (a[0] == b[0]) return a[1] - b[1];
			else return a[0] - b[0]; 
		});
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) dp[i] = team[i][1];

		int res = scores[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (team[i][1] >= team[j][1]) dp[i] = Math.max(dp[i], dp[j] + team[i][1]);
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}