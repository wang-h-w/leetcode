import java.util.*;

class MinMutation {
	public int minMutation(String startGene, String endGene, String[] bank) {
		if (bank.length == 0) return -1;
		Set<String> set = new HashSet<>();
		for (String s : bank) set.add(s);
		if (!set.contains(endGene)) return -1;
		char[] gene = new char[] {'A', 'C', 'G', 'T'};
		Deque<String> d = new ArrayDeque<>();
		Map<String, Integer> map = new HashMap<>();
		d.add(startGene);
		map.put(startGene, 0);

		while (!d.isEmpty()) {
			int size = d.size();
			while (size-- != 0) {
				StringBuffer sb = new StringBuffer(d.pollFirst());
				int step = map.get(sb.toString());
				for (int i = 0; i < 8; i++) {
					char c = sb.charAt(i);
					for (int j = 0; j < 4; j++) {
						if (c == gene[j]) continue;
						sb.setCharAt(i, gene[j]);
						String curr = sb.toString();
						if (set.contains(curr) && !map.containsKey(curr)) {
							d.offer(curr);
							map.put(curr, step + 1);
						}
						if (curr.equals(endGene)) return step + 1;
						sb.setCharAt(i, c);
					}
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