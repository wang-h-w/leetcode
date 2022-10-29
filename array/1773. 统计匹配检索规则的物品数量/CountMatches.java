import java.util.List;
import java.util.LinkedList;

class CountMatches {
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int idx = 0, res = 0;
		if (ruleKey.equals("type")) idx = 0;
		else if (ruleKey.equals("color")) idx = 1;
		else idx = 2;
		for (List<String> item : items) {
			res += item.get(idx).equals(ruleValue) ? 1 : 0;
		}
		return res;
	}
}