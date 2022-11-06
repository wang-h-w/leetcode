class Interpret {
	public String interpret(String command) {
		StringBuffer sb = new StringBuffer();
		int ptr = 0;
		while (ptr < command.length()) {
			char c = command.charAt(ptr++);
			if (c == 'G') sb.append('G');
			else if (c == '(') {
				if (command.charAt(ptr++) == ')') sb.append('o');
				else {
					sb.append("al");
					ptr += 2;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Interpret i = new Interpret();
		System.out.println(i.interpret("G()(al)"));
		System.out.println(i.interpret("G()()()()(al)"));
		System.out.println(i.interpret("(al)G(al)()()G"));
	}
}