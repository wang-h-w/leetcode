class ReformatNumber {
	public String reformatNumber(String number) {
		StringBuffer sb = new StringBuffer();
		int cnt = 0;
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if (c == ' ' || c == '-') continue;
			if (cnt == 3) {
				sb.append('-');
				cnt = 0;
			}
			
			sb.append(c);
			cnt++;
		}
		if (cnt == 1) {
			sb.deleteCharAt(sb.length() - 2);
			sb.insert(sb.length() - 2, '-');
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ReformatNumber ref = new ReformatNumber();
		System.out.println(ref.reformatNumber("1-23-45 6"));
		System.out.println(ref.reformatNumber("123 4-567"));
		System.out.println(ref.reformatNumber("123 4-5678"));
		System.out.println(ref.reformatNumber("1234"));
		System.out.println(ref.reformatNumber("--17-5 229 35-39475 "));
	}
}