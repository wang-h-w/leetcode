class MinimumLength {
	public int minimumLength(String s) {
		int n = s.length(), left = 0, right = n - 1;
		while (left < right) {
			char l = s.charAt(left), r = s.charAt(right);
			if (l != r) break;
			while (left < n && s.charAt(left) == l) left++;
			while (right >= 0 && s.charAt(right) == r) right--;
		}
		return Math.max(right - left + 1, 0);
	}

	public static void main(String[] args) {
		MinimumLength ml = new MinimumLength();
		System.out.println(ml.minimumLength("cccc"));
		System.out.println(ml.minimumLength("cabaabac"));
		System.out.println(ml.minimumLength("aabccabba"));
	}
}