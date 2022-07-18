import java.util.Map;
import java.util.HashMap;

class WordDictionary {
	private Node root;

	private static class Node {
		private boolean isKey;
		private Map<Character, Node> map;

		public Node(boolean b) {
			this.isKey = b;
			this.map = new HashMap<>();
		}
	}

	public WordDictionary() {
		this.root = new Node(false);
	}

	public void addWord(String word) {
		if (word.length() == 0) return;
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!curr.map.containsKey(c)) curr.map.put(c, new Node(false));
			curr = curr.map.get(c);
		}
		curr.isKey = true;
	}

	private boolean searchHelper(Node curr, String word) {
		if (word.length() == 0) return curr.isKey;
		char c = word.charAt(0);
		if (c == '.') {
			for (char ch : curr.map.keySet()) {
				boolean b = searchHelper(curr.map.get(ch), word.substring(1, word.length()));
				if (b) return true;
			}
			return false;
		} else {
			if (!curr.map.containsKey(c)) return false;
			return searchHelper(curr.map.get(c), word.substring(1, word.length()));
		}
	}

	public boolean search(String word) {
		if (word.length() == 0) return false;
		return searchHelper(root, word);
	}

	public static void main(String[] args) {
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad"));
		System.out.println(wd.search("bad"));
		System.out.println(wd.search(".ad"));
		System.out.println(wd.search("b.."));
	}
}