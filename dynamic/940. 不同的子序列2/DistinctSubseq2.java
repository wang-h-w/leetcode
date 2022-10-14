class DistinctSubseq2 {
	int MOD = (int)1e9+7;

    public int distinctSubseqII(String s) {
    	// f[i][j]为考虑前i个字符，且结尾字符为j的不同子序列的个数
        int n = s.length(), ans = 0;
        int[][] f = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                if (c != j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    int cur = 1;
                    for (int k = 0; k < 26; k++) cur = (cur + f[i - 1][k]) % MOD;
                    f[i][j] = cur;
                }
            }
        }
        for (int i = 0; i < 26; i++) ans = (ans + f[n][i]) % MOD;
        return ans;
    }

	public static void main(String[] args) {
		DistinctSubseq2 seq = new DistinctSubseq2();
		System.out.println(seq.distinctSubseqII("abc"));
		System.out.println(seq.distinctSubseqII("aba"));
		System.out.println(seq.distinctSubseqII("aaa"));
		System.out.println(seq.distinctSubseqII("aidgnaewpngdajfioaaaaadignedaingejidnaidgnaadsge"));
		System.out.println(seq.distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
	}
}