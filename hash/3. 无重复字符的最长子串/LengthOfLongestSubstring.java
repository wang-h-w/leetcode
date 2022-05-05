import java.util.HashMap;

class LengthOfLongestSubstring {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring len = new LengthOfLongestSubstring();
        String s1 = "abcabcabc";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = " ";
        String s5 = "dvdf";
        int result = len.lengthOfLongestSubstring(s5);
        System.out.println(result);
        
    }
}