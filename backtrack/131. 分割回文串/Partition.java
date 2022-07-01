import java.util.List;
import java.util.LinkedList;

class Partition {
	List<List<String>> ret = new LinkedList<>();
	LinkedList<String> path = new LinkedList<>();
	char[] word;

	public List<List<String>> partition(String s) {
		word = s.toCharArray();
		backtrack(0);
		return ret;
	}

	private void backtrack(int start) {
		if (start >= word.length) {
			ret.add(new LinkedList<>(path));
			return;
		}
		for (int i = start; i < word.length; i++) {
			if (!check(start, i)) continue;
			path.add(String.valueOf(word, start, i - start + 1));
			backtrack(i + 1);
			path.removeLast();
		}
	}

	private boolean check(int start, int end) {
		while (start < end) {
			if (word[start++] != word[end--]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Partition p = new Partition();
		System.out.println(p.partition("aab"));
		// System.out.println(p.partition("a"));
	}
}