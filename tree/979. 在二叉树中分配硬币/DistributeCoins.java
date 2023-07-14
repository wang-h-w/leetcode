class DistributeCoins {
    private int res;

    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    // int[0]：当前子树共有i个节点；int[1]：当前子树共有j枚硬币
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = dfs(root.left), right = dfs(root.right);
        int nodeNum = left[0] + right[0] + 1;
        int coinNum = left[1] + right[1] + root.val;
        res += Math.abs(nodeNum - coinNum);
        return new int[] {nodeNum, coinNum};
    }
}