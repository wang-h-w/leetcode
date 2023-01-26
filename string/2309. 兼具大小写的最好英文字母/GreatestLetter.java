class GreatestLetter {
	public String greatestLetter(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) set.add(s.charAt(i));
		for (int i = 25; i >= 0; i--) {
			char low = (char)('a' + i), high = (char)('A' + i);
			if (set.contains(low) && set.contains(high)) return String.valueOf(high);
		}
		return "";
	}
}