import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, LinkedList<String>> map = new HashMap<>();

		for (String s: strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sorted = String.valueOf(c);
			if (!map.containsKey(sorted)) map.put(sorted, new LinkedList<>());
			map.get(sorted).add(s);
		}
		return new LinkedList(map.values());
	}

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		// strs = new String[] {"a"};
		List<List<String>> result = ga.groupAnagrams(strs);
		System.out.println(result);
	}
}