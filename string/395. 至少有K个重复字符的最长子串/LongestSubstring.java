import java.util.Set;
import java.util.HashSet;

class LongestSubstring {
	public int longestSubstring(String s, int k) {
		if (s.length() < k) return 0;
		int[] count = new int[26];
		for (char c : s.toCharArray()) count[c-'a']++;

		int cnt = 0;
		while (cnt < s.length() && count[s.charAt(cnt) - 'a'] >= k) cnt++;
		if (cnt == s.length()) return s.length();

		int left = longestSubstring(s.substring(0, cnt), k);
		while (cnt < s.length() && count[s.charAt(cnt) - 'a'] < k) cnt++;
		int right = longestSubstring(s.substring(cnt, s.length()), k);

		return Math.max(left, right);
	}

	public static void main(String[] args) {
		LongestSubstring sub = new LongestSubstring();
		System.out.println(sub.longestSubstring("aaabb", 3));
		System.out.println(sub.longestSubstring("ababbc", 2));
	}
}