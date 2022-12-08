class SquareIsWhite {
	public boolean squareIsWhite(String coordinates) {
		int c1 = coordinates.charAt(0) - 'a', c2 = coordinates.charAt(1) - '1';
		if (c1 % 2 == c2 % 2) return false;
		return true;
		// 更简便的写法
		// return coordinates.charAt(0) % 2 + coordinates.charAt(1) % 2 == 1;
	}

	public static void main(String[] args) {
		SquareIsWhite siw = new SquareIsWhite();
		System.out.println(siw.squareIsWhite("a1"));
		System.out.println(siw.squareIsWhite("h3"));
		System.out.println(siw.squareIsWhite("c7"));
	}
}