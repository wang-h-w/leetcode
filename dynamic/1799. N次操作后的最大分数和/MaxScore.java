class MaxScore {
	private int n;
    private int[] dp;
    private int[][] gcd;
    
    public int maxScore(int[] nums) {
        n = nums.length;
        dp = new int[1 << n];
        gcd = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) gcd[i][j]= GCD(nums[i], nums[j]);
        }
        return dfs(1, (1 << n) - 1, 0, nums);
    }

    private int dfs(int x, int mask, int sum, int[] nums) { 
        if (x == n / 2 + 1) return sum;
        if (dp[mask] > 0) return sum + dp[mask]; // sum为已经选取的数获得的分数 + 未选取的数能够获得的最大分数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0) continue;
            for (int j = i + 1; j < n; j++) {
                if (((1 << j) & mask) == 0) continue;
                int next = mask ^ (1 << i) ^ (1 << j); 
                ans = Math.max(ans, dfs(x + 1,  next, sum + x * gcd[i][j], nums));
            }
        }
        dp[mask] = ans - sum; //ans为能够获得的总分数 减去sum后才是maks状态获得的最大分数
        return ans;
    }

    private int GCD(int a, int b) {
    	return b == 0? a : GCD(b, a % b);
    }
}