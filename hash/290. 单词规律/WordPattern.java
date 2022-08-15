import java.util.Map;
import java.util.HashMap;

class WordPattern {
	public boolean wordPattern(String pattern, String s) {
		Map<Character, String> map = new HashMap<>();
		String[] ss = s.split(" ");
		if (pattern.length() != ss.length) return false;
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(ss[i])) return false;
			}
			else {
				if (map.containsValue(ss[i])) return false;
				map.put(c, ss[i]);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
		System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
		System.out.println(wp.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
	}
}