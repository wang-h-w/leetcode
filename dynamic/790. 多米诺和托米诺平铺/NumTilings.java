class NumTilings {
	public int numTilings(int n) {
		// f[i][j]表示平铺前2*i的面板，j表示最后一列的状态
		// j=0铺满、j=1只有上方瓷砖、j=2只有下方瓷砖、j=3没有瓷砖
		long[] f = {1, 0, 0, 0};
		int mod = (int) 1e9 + 7;
		for (int i = 1; i <= n; i++) {
			long[] g = new long[4];
			g[0] = (f[0] + f[1] + f[2] + f[3]) % mod;
			g[1] = (f[2] + f[3]) % mod;
			g[2] = (f[1] + f[3]) % mod;
			g[3] = f[0];
			f = g;
		}
		return (int)f[0];
	}

	public static void main(String[] args) {
		NumTilings tile = new NumTilings();
		System.out.println(tile.numTilings(3));
		System.out.println(tile.numTilings(1));
		System.out.println(tile.numTilings(1000));
	}
}