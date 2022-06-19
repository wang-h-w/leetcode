import java.util.List;
import java.util.LinkedList;

class RestoreIpAddresses {
	List<String> ret = new LinkedList<>();
	String path = "";

	public List<String> restoreIpAddresses(String s) {
		if (s.length() < 4 || s.length() > 12) return ret;
		backtrack(s, s.length(), 0, 4);
		return ret;
	}

	private void backtrack(String s, int len, int start, int remain) {
		if (remain == 0) {
			ret.add(path.substring(0, path.length() - 1));
			return;
		}
		int min = len - (remain - 1) * 3;
		int max = len - (remain - 1);
		if (len <= 0 || max <= 0) return;
		min = min > 0 ? min : 1;
		max = max < 3 ? max : 3;
		for (; min <= max; min++) {
			String add = s.substring(start, start + min);
			if (Integer.valueOf(add) > 255 || (add.length() > 1 && add.substring(0, 1).equals("0"))) continue;
			path += add;
			path += ".";
			backtrack(s, len - min, start + min, remain - 1);
			path = path.substring(0, path.length() - min - 1);
		}
	}

	public static void main(String[] args) {
		RestoreIpAddresses ip = new RestoreIpAddresses();
		String s = "25525511135";
		s = "0000";
		s = "001010";
		System.out.println(ip.restoreIpAddresses(s));
	}
}