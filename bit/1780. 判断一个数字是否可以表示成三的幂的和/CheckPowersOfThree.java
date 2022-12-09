class CheckPowersOfThree {
	public boolean checkPowersOfThree(int n) {
		while (n > 0) {
			if (n % 3 == 2) return false;
			n /= 3;
		}
		return true;
	}

	public static void main(String[] args) {
		CheckPowersOfThree cpt = new CheckPowersOfThree();
		System.out.println(cpt.checkPowersOfThree(12));
		System.out.println(cpt.checkPowersOfThree(91));
		System.out.println(cpt.checkPowersOfThree(21));
	}
}