import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class WordBreakTrie {
	private Node root = new Node(false);

	public boolean wordBreak(String s, List<String> wordDict) {
		for (String word: wordDict) add(word);
		return wordBreakHelper(s, 0);
	}

	private boolean wordBreakHelper(String s, int start) {
		if (start >= s.length()) return true;
		Node curr = root;
		for (int i = start; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!curr.map.containsKey(c)) return false;
			if (curr.map.get(c).isKey) {
				if (wordBreakHelper(s, i + 1)) return true;
			}
			curr = curr.map.get(c);
		}
		return false;
	}

	private static class Node {
		private boolean isKey;
		private Map<Character, Node> map;

		public Node(boolean b) {
			this.isKey = b;
			this.map = new HashMap<>();
		}
	}

	public void add(String key) {
		if (key == null || key.length() == 0) return;
		Node curr = root;
		for (int i = 0, n = key.length(); i < n; i++) {
			char c = key.charAt(i);
			if (!curr.map.containsKey(c)) curr.map.put(c, new Node(false));
			curr = curr.map.get(c);
		}
		curr.isKey = true;
	}

	public static void main(String[] args) {
		WordBreakTrie wb = new WordBreakTrie();
		List<String> wordDict = new ArrayList<>();
		// wordDict.add("apple");
		// wordDict.add("pen");
		// wordDict.add("apple");
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		System.out.println(wb.wordBreak("catsandog", wordDict));
	}
}