import java.util.Stack;

class SimplifyPath {
	public String simplifyPath(String path) {
		String[] content = path.split("/");
		String ret = "";
		Stack<Integer> len = new Stack<>();

		for (String s: content) {
			if (s.equals("")) continue;
			if (s.equals(".")) continue;
			if (s.equals("..") && ret.length() != 0) {
				ret = ret.substring(0, ret.length() - len.pop());
				continue;
			} else if (s.equals("..")) {
				continue;
			}
			ret = ret + "/" + s;
			len.push(s.length() + 1);
		}
		if (ret.length() == 0) ret = "/";
		return ret;
	}

	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		String path = "/home/.//foo/../a";
		path = "/a/./b/../../c/";
		System.out.println("Original: " + path);
		System.out.println("Simplifid: " + s.simplifyPath(path));
	}
}