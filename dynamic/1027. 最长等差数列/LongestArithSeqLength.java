class LongestArithSeqLength {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        // f[i][j]：以nums[i]结尾且公差为j的等差数列的最大长度
        int[][] f = new int[n][1001];
        for (int i = 1; i < n; ++i) {
            for (int k = 0; k < i; ++k) {
                int j = nums[i] - nums[k] + 500;
                f[i][j] = Math.max(f[i][j], f[k][j] + 1);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans + 1;
    }
}