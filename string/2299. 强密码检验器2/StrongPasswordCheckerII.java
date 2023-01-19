class StrongPasswordCheckerII {
	public boolean strongPasswordCheckerII(String password) {
		if (password.length() < 8) return false;
		String special = "!@#$%^&*()-+";
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < special.length(); i++) set.add(special.charAt(i));
		int flag = 0;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (i != 0 && c == password.charAt(i - 1)) return false;
			if ('a' <= c && c <= 'z') flag |= 1;
			else if ('A' <= c && c <= 'Z') flag |= (1 << 1);
			else if ('0' <= c && c <= '9') flag |= (1 << 2);
			else if (set.contains(c)) flag |= (1 << 3);
		}
		return flag == 0b1111;
	}
}