class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int ptr1 = 0, ptr2 = 0, n1 = s.length(), n2 = t.length();
		while (ptr1 < n1 && ptr2 < n2) {
			char c = s.charAt(ptr1);
			while (ptr2 < n2 && c != t.charAt(ptr2)) ptr2++;
			if (ptr2 >= n2) break;
			ptr1++;
			ptr2++;
		}
		return ptr1 == n1;
	}
}