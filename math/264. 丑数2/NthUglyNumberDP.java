class NthUglyNumberDP {
	public int nthUglyNumber(int n) {
		// 三指针法和最小堆法的区别：三指针先排序再加入，最小堆先加入再排序
		// dp数组：第i个位置表示第i个丑数，注意此时关系式的下标是通过n2、n3、n5三个指针给出的
		int n2 = 0, n3 = 0, n5 = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(2 * dp[n2], Math.min(3 * dp[n3], 5 * dp[n5]));
			if (dp[i] == 2 * dp[n2]) n2++;
			if (dp[i] == 3 * dp[n3]) n3++;
			if (dp[i] == 5 * dp[n5]) n5++;
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		NthUglyNumberDP n = new NthUglyNumberDP();
		System.out.println(n.nthUglyNumber(10));
		System.out.println(n.nthUglyNumber(1407));
	}
}