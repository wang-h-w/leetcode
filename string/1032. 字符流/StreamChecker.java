class StreamChecker {
	private Trie trie;
	private StringBuilder sb;

	public StreamChecker(String[] words) {
		trie = new Trie();
		sb = new StringBuilder();
		for (String word : words) trie.insert(word);
	}

	public boolean query(char letter) {
		sb.append(letter);
		return trie.query(sb.toString());
	}
}

class Trie {
	Trie[] children = new Trie[26];
	boolean isKey = false;

	public void insert(String w) {
		Trie node = this;
		for (int i = w.length() - 1; i >= 0; i--) {
			int idx = w.charAt(i) - 'a';
			if (node.children[idx] == null) node.children[idx] = new Trie();
			node = node.children[idx];
		}
		node.isKey = true;
	}

	public boolean query(String w) {
		Trie node = this;
		for (int i = w.length() - 1; i >= 0; i--) {
			int idx = w.charAt(i) - 'a';
			if (node.children[idx] == null) return false;
			node = node.children[idx];
			if (node.isKey) return true;
		}
		return false;
	}
}