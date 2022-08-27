class IsPowerOfThree {
	public boolean isPowerOfThree(int n) {
		if (n <= 0) return false;
		String s = Integer.toString(n, 3);
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '2') return false;
			if (s.charAt(i) == '1') cnt++;
			if (cnt > 1) return false; 
		}
		return cnt == 1;
	}

	public static void main(String[] args) {
		IsPowerOfThree p = new IsPowerOfThree();
		System.out.println(p.isPowerOfThree(27));
		System.out.println(p.isPowerOfThree(0));
		System.out.println(p.isPowerOfThree(9));
		System.out.println(p.isPowerOfThree(45));
	}
}