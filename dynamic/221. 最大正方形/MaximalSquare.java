class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m < 1) return 0;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]); 
                }
            }
        }
        
        return max * max;
	}

	public static void main(String[] args) {
		MaximalSquare m = new MaximalSquare();
		char[][] matrix = new char[][] {{'1','0','1','0','0'},
										{'1','0','1','1','1'},
										{'1','1','1','1','1'},
										{'1','0','0','1','0'}};
		System.out.println(m.maximalSquare(matrix));
		matrix = new char[][] {{'0'},
							   {'1'}};
	   System.out.println(m.maximalSquare(matrix));
	}
}