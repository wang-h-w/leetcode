import java.util.Map;
import java.util.HashMap;

class IsIsomorphic {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i), c2 = t.charAt(i);
			if (map.containsKey(c1)) {
				if (c2 != map.get(c1)) return false;
				continue;
			}
			if (map.containsValue(c2)) return false;
			map.put(c1, c2);
		}

		return true;
	}

	public static void main(String[] args) {
		IsIsomorphic is = new IsIsomorphic();
		System.out.println(is.isIsomorphic("egg", "add"));
		System.out.println(is.isIsomorphic("foo", "bar"));
		System.out.println(is.isIsomorphic("paper", "title"));
	}
}