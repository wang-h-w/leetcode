class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (String s: strs) {
            while (!s.startsWith(ans)) {
                if (ans.length() == 0) {
                    return "";
                }
                ans = ans.substring(0, ans.length() - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(l.longestCommonPrefix(strs));
    }
}