class ToHex {
	public String toHex(int num) {
		if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int u = num & 15;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
	}

	public static void main(String[] args) {
		ToHex t = new ToHex();
		System.out.println(t.toHex(26));
		System.out.println(t.toHex(-1));
		System.out.println(t.toHex(24834));
	}
}