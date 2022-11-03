class FindMaximumXOR {
	// 0-1字典树的典型应用
	private static final int MAX_INT_BITS = 30;
	TrieNode root = new TrieNode();
	
	static class TrieNode {
		TrieNode[] child = new TrieNode[2]; // 每个二进制位只涉及到0或1，因此数组容量为2即可
	}
	
	private void add(int num) {
		// 在这里，字典树的高度是固定的，因此无需记录哪一个节点是终止节点（实际上都是叶子节点）
		TrieNode p = this.root;
		for (int i = MAX_INT_BITS; i >= 0; i--) {
			int bit = num >> i & 1; // 从高位到低位加入字典树
			if (p.child[bit] == null) p.child[bit] = new TrieNode();
			p = p.child[bit];
		}
	}
	
	private int search(int num) {
		TrieNode p = this.root;
		int res = 0;
		for (int i = MAX_INT_BITS; i >= 0; i--) {
			int bit = num >> i & 1;
			if (p.child[bit ^ 1] != null) { // 从高到低，贪心选取不同的位（x ^ 1 = ~x）
				res += (1 << i); // 如果能找到不同的，则这一位异或之后为1
				p = p.child[bit ^ 1];
			} else p = p.child[bit]; // 这里隐含着，如果没有不同的，则异或后该位为0
		}
		return res;
	}
	
	public int findMaximumXOR(int[] nums) {
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			add(nums[i-1]);
			max = Math.max(max, search(nums[i]));
		}
		return max;
	}
}