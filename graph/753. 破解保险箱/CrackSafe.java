class CrackSafe {
	StringBuilder sb = new StringBuilder();
    int n, k, mod;
    Set<Integer> vis = new HashSet<>(); //判断每条边是否访问过

    public String crackSafe(int N, int K) {
        n = N; k = K; mod = (int)Math.pow(10, n - 1); 
        dfs(0); //从0点出发
        sb.append("0".repeat(n - 1));
        return sb.toString();
    }

    private void dfs(int u) {
        for (int i = 0; i < k; i++) { //对于每个点循环k条边即可
            int v = u * 10 + i; //即边的编号
            if (vis.contains(v)) continue; 
            vis.add(v); //标记该边已经访问 
            dfs(v % mod); //去掉第一位为结点编号 
            sb.append(i); //添加最后一个数字
        }
    }
}