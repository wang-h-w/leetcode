import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class OriginalDigits {
	private Map<Character, Integer> map;
	private StringBuffer sb;
	
	public String originalDigits(String s) {
		int n = s.length();
		map = new HashMap<>();
		sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}
		find(2, 'w', new char[] {'t', 'o'});
		find(4, 'u', new char[] {'f', 'o', 'r'});
		find(6, 'x', new char[] {'s', 'i'});
		find(8, 'g', new char[] {'e', 'i', 'h', 't'});
		find(3, 'h', new char[] {'t', 'r', 'e', 'e'});
		find(5, 'f', new char[] {'i', 'v', 'e'});
		find(7, 'v', new char[] {'s', 'e', 'e', 'n'});
		find(9, 'i', new char[] {'n', 'n', 'e'});
		find(1, 'n', new char[] {'o', 'e'});
		find(0, 'e', new char[] {'z', 'r', 'o'});
		
		char[] res = sb.toString().toCharArray();
		Arrays.sort(res);
		sb = new StringBuffer();
		for (char c : res) sb.append(c);
		return sb.toString();
	}
	
	private void find(int n, char key, char[] others) {
		if (!map.containsKey(key)) return;
		int times = map.remove(key);
		for (char c : others) {
			map.put(c, map.get(c) - times);
			if (map.get(c) == 0) map.remove(c);
		}
		for (int i = 0; i < times; i++) sb.append(n);
	}
}