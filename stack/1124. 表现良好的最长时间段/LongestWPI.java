class LongestWPI {
	public int longestWPI(int[] hours) {
		int n = hours.length, ans = 0;
        var s = new int[n + 1]; // 前缀和
        var st = new ArrayDeque<Integer>();
        st.push(0); // s[0]
        for (int j = 1; j <= n; ++j) {
            s[j] = s[j - 1] + (hours[j - 1] > 8 ? 1 : -1);
            if (s[j] < s[st.peek()]) st.push(j); // 感兴趣的 j
        }
        for (int i = n; i > 0; --i)
            while (!st.isEmpty() && s[i] > s[st.peek()])
                ans = Math.max(ans, i - st.pop()); // [栈顶,i) 可能是最长子数组
        return ans;
	}
}