import java.util.*;

class LadderLength {
	private Set<String> set;

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (wordList.size() == 0) return 0;
		set = new HashSet<>();
		for (String s : wordList) set.add(s);
		if (!set.contains(endWord)) return 0;
		Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
		d1.offer(beginWord); d2.offer(endWord);
		Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
		m1.put(beginWord, 0); m2.put(endWord, 0);
		while (!d1.isEmpty() && !d2.isEmpty()) {
			int t = 0;
			if (d1.size() <= d2.size()) t = update(d1, m1, m2);
			else t = update(d2, m2, m1);
			if (t != 0) return t + 1;
		}
		return 0;
	}

	private int update(Deque<String> d, Map<String, Integer> curr, Map<String, Integer> other) {
		int size = d.size();
		while (size-- > 0) {
			StringBuffer sb = new StringBuffer(d.poll());
			int step = curr.get(sb.toString());
			for (int i = 0; i < sb.toString().length(); i++) {
				char c = sb.charAt(i);
				for (int j = 0; j < 26; j++) {
					char change = (char)('a' + j);
					if (c == change) continue;
					sb.setCharAt(i, change);
					String s = sb.toString();
					if (other.containsKey(s)) return other.get(s) + step + 1;
					if (set.contains(s) && !curr.containsKey(s)) {
						curr.put(s, step + 1);
						d.offer(s);
					}
					sb.setCharAt(i, c);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		LadderLength ll = new LadderLength();
		List<String> wordList = new LinkedList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(ll.ladderLength("hit", "cog", wordList));
		wordList.remove("cog");
		System.out.println(ll.ladderLength("hit", "cog", wordList));
	}
}