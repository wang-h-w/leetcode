import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, Integer> hs = new HashMap<>();
		List<List<String>> ret = new LinkedList<>();

		for (String s: strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sorted = Arrays.toString(c);
			if (hs.containsKey(sorted)) {
				ret.get(hs.get(sorted)).add(s);
			} else {
				hs.put(sorted, ret.size());
				List<String> l = new LinkedList<>();
				l.add(s);
				ret.add(l);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		strs = new String[] {"a"};
		List<List<String>> result = ga.groupAnagrams(strs);
		System.out.println(result);
	}
}