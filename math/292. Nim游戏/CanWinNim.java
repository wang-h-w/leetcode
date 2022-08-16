class CanWinNim {
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}

	public static void main(String[] args) {
		CanWinNim c = new CanWinNim();
		System.out.println(c.canWinNim(4));
		System.out.println(c.canWinNim(1));
		System.out.println(c.canWinNim(2));
	}
}