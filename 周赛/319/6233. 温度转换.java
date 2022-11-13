class Solution {
	public double[] convertTemperature(double celsius) {
		double[] res = new double[2];
		res[0] = celsius + 273.15;
		res[1] = celsius * 1.8 + 32.00;
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		double[] res = s.convertTemperature(36.50);
		for (double d : res) System.out.print(d + " ");
		System.out.println();
		res = s.convertTemperature(122.11);
		for (double d : res) System.out.print(d + " ");
		System.out.println();
	}
}