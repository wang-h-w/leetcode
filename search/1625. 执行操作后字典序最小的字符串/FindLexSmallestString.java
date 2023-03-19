import java.util.*;

class FindLexSmallestString {
	public String findLexSmallestString(String s, int a, int b) {
		int n = s.length();
		TreeSet<String> set = new TreeSet<>();
		Deque<String> dq = new ArrayDeque<>();
		dq.offer(s);
		set.add(s);
		while (!dq.isEmpty()) {
			String curr = dq.pollFirst();
			char[] currArr = curr.toCharArray();
			// add a
			for (int i = 1; i < n; i += 2) currArr[i] = (char)((currArr[i] - '0' + a) % 10 + '0');
			String currAdd = new String(currArr);
			if (!set.contains(currAdd)) {
				set.add(currAdd);
				dq.offerLast(currAdd);
			}
			// move b
			String l = curr.substring(0, n - b), r = curr.substring(n - b, n);
			String currMove = r + l;
			if (!set.contains(currMove)) {
				set.add(currMove);
				dq.offerLast(currMove);
			}
		}
		return set.first();
	}

	public static void main(String[] args) {
		FindLexSmallestString f = new FindLexSmallestString();
		System.out.println(f.findLexSmallestString("5525", 9, 2));
	}
}