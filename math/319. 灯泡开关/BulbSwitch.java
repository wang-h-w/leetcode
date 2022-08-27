class BulbSwitch {
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

	public static void main(String[] args) {
		BulbSwitch b = new BulbSwitch();
		System.out.println(b.bulbSwitch(40374));
	}
}