import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class FindAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new LinkedList<>();
		int[] target = new int[26];
		int[] real = new int[26];
		int valid = 0, unique = 0;
		for (int i = 0; i < p.length(); i++) target[p.charAt(i) - 'a']++;
		for (int i : target) if (i != 0) unique++; // 词频统计
		int left = 0, right = 0;
		while (right < s.length()) {
			char c = s.charAt(right++);
			if (target[c - 'a'] != 0) {
				real[c - 'a']++;
				if (real[c - 'a'] == target[c - 'a']) valid++;
			}
			// 限制窗口的最大长度
			while (right - left >= p.length()) {
				if (valid == unique) res.add(left);
				char d = s.charAt(left++);
				if (target[d - 'a'] != 0) {
					if (real[d - 'a'] == target[d - 'a']) valid--;
					real[d - 'a']--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FindAnagrams fa = new FindAnagrams();
		System.out.println(fa.findAnagrams("cbaebabacd", "abc"));
		System.out.println(fa.findAnagrams("abab", "ab"));
	}
}

