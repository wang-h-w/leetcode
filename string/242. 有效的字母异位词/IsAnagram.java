import java.util.Map;
import java.util.HashMap;

class IsAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) map.put(c, map.get(c) + 1);
			else map.put(c, 1);
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!map.containsKey(c)) return false;
			map.put(c, map.get(c) - 1);
			if (map.get(c) == 0) map.remove(c);
		}

		return true;
	}

	public static void main(String[] args) {
		IsAnagram a = new IsAnagram();
		System.out.println(a.isAnagram("anagram", "nagaram"));
		System.out.println(a.isAnagram("rat", "car"));
	}
}