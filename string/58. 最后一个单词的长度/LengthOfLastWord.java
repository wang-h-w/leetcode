class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int length = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') length++;
			if (length != 0 && s.charAt(i) == ' ') break;
		}
		return length;
	}

	public static void main(String[] args) {
		LengthOfLastWord word = new LengthOfLastWord();
		String s = "   fly me   to   the moon  ";
		s = "Hello World";
		s = "luffy is still joyboy";
		s = " a bb ";
		System.out.println(word.lengthOfLastWord(s));
	}
}