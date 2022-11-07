import java.util.List;
import java.util.LinkedList;

class AmbiguousCoordinates {
	public List<String> ambiguousCoordinates(String s) {
		List<String> ret = new LinkedList<>();
		for (int bp = 2; bp <= s.length() - 2; bp++) {
			String left = s.substring(1, bp), right = s.substring(bp, s.length() - 1);
			List<String> ll = getValid(left), rr = getValid(right);
			if (ll.size() == 0 || rr.size() == 0) continue;
			for (String l : ll) {
				for (String r : rr) ret.add("(" + l + ", " + r + ")");
			}
		}
		return ret;
	}

	private List<String> getValid(String s) {
		List<String> res = new LinkedList<>();
		int len = s.length();
		// no digits
		if (len == 1 || s.charAt(0) != '0') res.add(s);
		// have digits
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i), right = s.substring(i, s.length());
			if (left.length() > 1 && left.charAt(0) == '0') continue;
			if (right.charAt(right.length() - 1) == '0') continue;
			res.add(left + "." + right);
		}
		return res;
	}
}