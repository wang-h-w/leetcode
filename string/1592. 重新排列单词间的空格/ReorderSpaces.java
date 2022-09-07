class ReorderSpaces {
	public String reorderSpaces(String text) {
		StringBuffer sb = new StringBuffer();
		int countSpace = 0, countWord = 0;
		text = " " + text;
		int n = text.length();
		
		for (int i = 1; i < n; i++) {
			char c = text.charAt(i);
			char prev = text.charAt(i-1);
			if (c == ' ') countSpace++;
			if (c != ' ' && prev == ' ') countWord++;
		}
		
		int spaceEach = countSpace / Math.max(countWord - 1, 1);
		int last = countSpace % Math.max(countWord - 1, 1);
		if (countWord == 1) last = countSpace;
		int idx = 0;
		
		for (int i = 0; i < countWord; i++) {
			while (idx < n && text.charAt(idx) == ' ') idx++;
			while (idx < n && text.charAt(idx) != ' ') sb.append(text.charAt(idx++));
			if (i < countWord - 1) for (int j = 0; j < spaceEach; j++) sb.append(' ');
			else for (int j = 0; j < last; j++) sb.append(' ');
		}
		
		return sb.toString();
	}
}