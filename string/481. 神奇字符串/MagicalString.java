class MagicalString {
	public int magicalString(int n) {
		int[] memo = new int[n + 1];
		int[] p = new int[] {0, 2, 1};
		memo[0] = 1;
		int slow = 0, fast = 0, cnt = 1;
		while (fast < n - 1) {
			if (memo[slow + 1] == 0) memo[slow + 1] = p[memo[slow]];
			slow++;
			for (int i = 1; i <= memo[slow]; i++) {
				memo[fast + i] = p[memo[fast]];
				if (memo[fast + i] == 1 && fast + i < n) cnt++;
			}
			fast = fast + memo[slow];
		}
		return cnt;
	}

	public static void main(String[] args) {
		MagicalString ms = new MagicalString();
		System.out.println(ms.magicalString(6));
		System.out.println(ms.magicalString(1));
		System.out.println(ms.magicalString(2847));
		System.out.println(ms.magicalString(4));
	}
}