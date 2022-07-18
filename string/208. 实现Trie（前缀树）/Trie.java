import java.util.Map;
import java.util.HashMap;

class Trie {
	private Node root;

	private static class Node {
		private boolean isKey;
		private Map<Character, Node> map;

		public Node(boolean b) {
			this.isKey = b;
			this.map = new HashMap<>();
		}
	}

	public Trie() {
		this.root = new Node(false);
	}

	public void insert(String word) {
		if (word.length() == 0) return;
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!curr.map.containsKey(c)) curr.map.put(c, new Node(false));
			curr = curr.map.get(c);
		}
		curr.isKey = true;
	}

	public boolean search(String word) {
		if (word.length() == 0) return false;
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!curr.map.containsKey(c)) return false;
			curr = curr.map.get(c);
		}
		return curr.isKey;
	}

	public boolean startsWith(String prefix) {
		if (prefix.length() == 0) return false;
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (!curr.map.containsKey(c)) return false;
			curr = curr.map.get(c);
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // 返回 True
		System.out.println(trie.search("app"));     // 返回 False
		System.out.println(trie.startsWith("app")); // 返回 True
		trie.insert("app");
		System.out.println(trie.search("app"));     // 返回 True
	}
}