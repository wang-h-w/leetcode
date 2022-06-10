import java.util.Stack;

class SimplifyPath {
	public String simplifyPath(String path) {
		String[] content = path.split("/");
		StringBuilder ret = new StringBuilder();
		Stack<String> stack = new Stack<>();

		for (String s: content) {
			if (s.equals("..") && !stack.empty()) stack.pop();
			else if (!s.equals("") && !s.equals(".") && !s.equals("..")) stack.push(s);
		}
		for (String i: stack) ret.append("/" + i);
		
		return ret.length() == 0 ? "/" : ret.toString();
	}

	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		String path = "/home/.//foo/../a";
		path = "/a/./b/../../c/";
		System.out.println("Original: " + path);
		System.out.println("Simplifid: " + s.simplifyPath(path));
	}
}