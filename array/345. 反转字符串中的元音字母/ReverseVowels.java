class ReverseVowels {
	public String reverseVowels(String s) {
		char[] cs = s.toCharArray();
		int n = s.length(), left = 0, right = n - 1;
		while (left < right) {
			while (left < n && !vowel(cs[left])) left++;
			while (right > 0 && !vowel(cs[right])) right--;
			if (left < right) {
				char temp = cs[left];
				cs[left++] = cs[right];
				cs[right--] = temp;
			}
		}
		return new String(cs);
	}

	private boolean vowel(char ch) {
		return "aeiouAEIOU".indexOf(ch) >= 0;
	}

	public static void main(String[] args) {
		ReverseVowels r = new ReverseVowels();
		System.out.println(r.reverseVowels("hello"));
		System.out.println(r.reverseVowels("leetcode"));
	}
}