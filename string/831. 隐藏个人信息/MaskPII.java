class MaskPII {
	public String maskPII(String s) {
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		if ('a' <= s.charAt(0) && s.charAt(0) <= 'z') {
			// email
			int p = 1;
			sb.append(s.charAt(0));
			while (p < n) {
				if (s.charAt(p) == '@') {
					if (p >= 2) {
						sb.append("*****");
						sb.append(s.charAt(p - 1));
					}
					while (p < n) sb.append(s.charAt(p++));
				}
				p++;
			}
		} else {
			// phone
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if ('0' <= s.charAt(i) && s.charAt(i) <= '9') temp.append(s.charAt(i));
			}
			int size = temp.length();
			if (size == 10) sb.append("***-***-");
			else if (size == 11) sb.append("+*-***-***-");
			else if (size == 12) sb.append("+**-***-***-");
			else if (size == 13) sb.append("+***-***-***-");
			for (int i = size - 4; i < size; i++) sb.append(temp.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MaskPII m = new MaskPII();
		System.out.println(m.maskPII("LeetCode@LeetCode.com"));
		System.out.println(m.maskPII("AB@qq.com"));
		System.out.println(m.maskPII("1(234)567-890"));
		System.out.println(m.maskPII("86-(10)12345678"));
	}
}