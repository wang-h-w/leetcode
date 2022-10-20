class CanCross {
	public boolean canCross(int[] stones) {
		int n = stones.length;
        if (stones[1] != 1) return false;
        boolean[][] f = new boolean[n + 1][n + 1];
        f[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
                // 我们知道从位置 j 到位置 i 是需要步长为 k 的跳跃
                // 而从位置 j 发起的跳跃最多不超过 j + 1
                // 因为每次跳跃，下标至少增加 1，而步长最多增加 1 
                if (k <= j + 1) {
                    f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i]) return true;
        }
        return false;
	}

	public static void main(String[] args) {
		CanCross cross = new CanCross();
		System.out.println(cross.canCross(new int[] {0,1,3,5,6,8,12,17}));
		System.out.println(cross.canCross(new int[] {0,1,2,3,4,8,9,11}));
	}
}