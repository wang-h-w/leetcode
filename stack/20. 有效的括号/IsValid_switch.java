class IsValid_switch {
	public boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		int[] nums = new int[s.length()];
		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			int curr = char2num(s.charAt(i));
			if (curr > 0) {
				nums[pos] = curr;
				pos += 1;
			}
			if (curr < 0) {
				if (pos == 0 || curr + nums[pos - 1] != 0) {
					return false;
				}
				pos -= 1;
			}
		}
		if (pos == 0) {
			return true;
		}
		return false;
	}

	private int char2num(Character c) {
		switch(c) {
			case '(': return 1;
			case ')': return -1;
			case '[': return 2;
			case ']': return -2;
			case '{': return 3;
			case '}': return -3;
			default: return 0;
		}
	}

	public static void main(String[] args) {
		IsValid_switch v = new IsValid_switch();
		String s = "){";
		if (v.isValid(s)) {
			System.out.println("valid");
		} else {
			System.out.println("not valid");
		}
	}
}