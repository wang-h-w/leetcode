class BeautySum {
	public int beautySum(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] cnt = new int[26];
			for (int j = i; j < s.length(); j++) {
				cnt[s.charAt(j)-'a']++;
				int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
				for (int k = 0; k < 26; k++) {
					max = Math.max(max, cnt[k]);
					if (cnt[k] > 0) min = Math.min(min, cnt[k]);
				}
				res += max - min;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		BeautySum bs = new BeautySum();
		System.out.println(bs.beautySum("aabcb"));
		System.out.println(bs.beautySum("aabcbaa"));
	}
}