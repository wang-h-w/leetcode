class Solution {
	public int maxPalindromes(String _s, int k) {
		// 定义f[i]表示s[0..i−1]中的不重叠回文子字符串的最大数目（不一定以s[i]为结尾）
		char[] s = _s.toCharArray();
		int n = s.length;
		int[] f = new int[n + 1]; // f[0]用来定义空字符串
		for (int i = 0; i < 2 * n - 1; i++) {
			int l = i / 2, r = l + i % 2; // 中心扩展法，同时解决中心为一个字符或两个字符的情况
			f[l + 1] = Math.max(f[l + 1], f[l]);
			for (; l >= 0 && r < n && s[l] == s[r]; l--, r++) {
				if (r - l + 1 >= k) f[r + 1] = Math.max(f[r + 1], f[l] + 1);
			}
		}
		return f[n];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxPalindromes("abaccdbbd", 3));
		System.out.println(s.maxPalindromes("adbcda", 2));
	}
}