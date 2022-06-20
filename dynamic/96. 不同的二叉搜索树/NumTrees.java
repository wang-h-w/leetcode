import java.util.List;
import java.util.LinkedList;

class NumTrees {
	public int numTrees(int n) {
		// 一维数组记录历史信息：第i个为总数为i的节点可以组成的二叉搜索树的数目
		int[] dp = new int[n+1];
		dp[0] = 1; // null
		dp[1] = 1;
		if (n == 1) return dp[1];
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i-j-1];
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		NumTrees n = new NumTrees();
		for (int i = 1; i <= 19; i++) System.out.print(n.numTrees(i) + " ");
	}
}