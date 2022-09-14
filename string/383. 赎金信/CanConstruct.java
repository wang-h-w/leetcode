class CanConstruct {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] record = new int[26];
		for (int i = 0; i < magazine.length(); i++) record[magazine.charAt(i) - 'a']++;
		for (int i = 0; i < ransomNote.length(); i++) {
			record[ransomNote.charAt(i) - 'a']--;
			if (record[ransomNote.charAt(i) - 'a'] < 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		CanConstruct cc = new CanConstruct();
		System.out.println(cc.canConstruct("a","b"));
		System.out.println(cc.canConstruct("aa","ba"));
		System.out.println(cc.canConstruct("aa","aba"));
	}
}