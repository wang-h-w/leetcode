class KMP {
	// haystack为文本串，needle为模式串
    public int kmp(String haystack, String needle) {
     	if (needle.length() == 0) return 0;
        int j = -1;
        int[] next = new int[needle.length()];
        getNext(needle, next);

        for(int i = 0; i < haystack.length(); i++){
            // 前后缀不相同时
            // i指针保持不变，j指针回退
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            // 前后缀相同的情况
            if (haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if (j == needle.length() - 1) return i - needle.length() + 1;

        }
        return -1;
    }

    // 构造next数组
    private void getNext(String s, int[] next){
    	int j = -1;
        // 初始化数组
        next[0] = j;
        // 遍历模式串，j指向前缀末尾，i指向后缀末尾
        for(int i = 1; i < s.length(); i++){
        	// 当前后缀不相同时的情况
            while(j >= 0 && s.charAt(i) != s.charAt(j+1)){
                j = next[j];
            }
            // 当前后缀相同时
            if(s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }

	public static void main(String[] args) {
		KMP ss = new KMP();
		System.out.println(ss.kmp("mississippi", "issip"));
	}
}