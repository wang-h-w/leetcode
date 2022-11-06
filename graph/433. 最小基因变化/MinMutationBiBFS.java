import java.util.*;

class MinMutation {
	private Set<String> set = new HashSet<>();
	private static final char[] gene = new char[] {'A', 'C', 'G', 'T'};

	public int minMutation(String startGene, String endGene, String[] bank) {
		if (bank.length == 0) return -1;
		for (String s : bank) set.add(s);
		if (!set.contains(endGene)) return -1;
		Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>(); // 从起点和终点分别BFS
		d1.offer(startGene); d2.offer(endGene);
		Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>(); // 记录是否访问过
		map1.put(startGene, 0); map2.put(endGene, 0);
		while (!d1.isEmpty() && !d2.isEmpty()) {
			int t = -1;
			if (d1.size() <= d2.size()) t = update(d1, map1, map2);
			else t = update(d2, map2, map1);
			if (t != -1) return t;
		}
		return -1;		
	}

	// 选择更小的队列进行BFS
	private int update(Deque<String> d, Map<String, Integer> curr, Map<String, Integer> other) {
		int size = d.size();
		while (size-- != 0) {
			StringBuffer sb = new StringBuffer(d.pollFirst());
			int step = curr.get(sb.toString());
			for (int i = 0; i < 8; i++) {
				char c = sb.charAt(i);
				for (int j = 0; j < 4; j++) {
					if (c == gene[j]) continue;
					sb.setCharAt(i, gene[j]);
					String s = sb.toString();
					if (other.containsKey(s)) return other.get(s) + step + 1;
					if (set.contains(s) && !curr.containsKey(s)) {
						d.offer(s);
						curr.put(s, step + 1);
					}
					sb.setCharAt(i, c);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MinMutation mm = new MinMutation();
		System.out.println(mm.minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"}));
		System.out.println(mm.minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
		System.out.println(mm.minMutation("AAAAACCC", "AACCCCCC", new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
	}
}