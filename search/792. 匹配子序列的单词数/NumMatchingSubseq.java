import java.util.ArrayList;

class NumMatchingSubseq {
	public int numMatchingSubseq(String s, String[] words) {
		ArrayList<Integer>[] list = new ArrayList[26];
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			if (list[idx] == null) list[idx] = new ArrayList<>();
			list[idx].add(i);
		}

		int res = 0;
		for (String word : words) {
			int i = 0, j = 0;
			for (; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (list[idx] == null) break;
				int pos = findLeft(list[idx], j); // 找到大于j的最小值
				if (pos == -1) break;
				j = list[idx].get(pos) + 1;
			}
			if (i == word.length()) res++;
		}
		return res;
	}

	private int findLeft(ArrayList<Integer> arr, int target) {
		int left = 0, right = arr.size();
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (target > arr.get(mid)) left = mid + 1;
			else right = mid;
		}
		if (left == arr.size()) return -1;
		return left;
	}

	public static void main(String[] args) {
		NumMatchingSubseq m = new NumMatchingSubseq();
		System.out.println(m.numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
		System.out.println(m.numMatchingSubseq("dsahjpjauf", new String[] {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
	}
}