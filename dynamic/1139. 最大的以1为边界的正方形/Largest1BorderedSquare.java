class Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0) continue;
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                if (curSide <= maxSide) continue;
                for (; curSide > maxSide; curSide--) {
                    if (dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
                        maxSide = curSide;
                        break;
                    }
                }
            }
        }

        return maxSide * maxSide;
    }
}