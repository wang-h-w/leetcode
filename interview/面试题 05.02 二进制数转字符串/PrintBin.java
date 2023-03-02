class PrintBin {
	public String printBin(double num) {
		StringBuffer sb = new StringBuffer();
		sb.append("0.");
		int count = 2;
		double next = 0.0, diff = 1e-10f;
		while (sb.length() < 32 && num != 0) {
			num *= 2;
			int bit = (int) Math.floor(num);
			sb.append(bit);
			num -= bit;
		}
		return num != 0 ? "ERROR" : sb.toString();
	}

	public static void main(String[] args) {
		PrintBin pb = new PrintBin();
		System.out.println(pb.printBin(0.625));
		System.out.println(pb.printBin(0.1));
		System.out.println(pb.printBin(0.2868311060592532));
	}
}