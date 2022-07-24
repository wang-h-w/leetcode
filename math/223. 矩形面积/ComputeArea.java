class ComputeArea {
	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int lonUnion = Math.min(ax2, bx2) - Math.max(ax1, bx1);
		int latUnion = Math.min(ay2, by2) - Math.max(ay1, by1);
		int rec1 = (ax2 - ax1) * (ay2 - ay1);
		int rec2 = (bx2 - bx1) * (by2 - by1);
		if (lonUnion <= 0 || latUnion <= 0) return rec1 + rec2;
		return rec1 - lonUnion * latUnion + rec2;
	}

	public static void main(String[] args) {
		ComputeArea c = new ComputeArea();
		System.out.println(c.computeArea(-3,0,3,4,0,-1,9,2));
		System.out.println(c.computeArea(-2,-2,2,2,-2,-2,2,2));
	}
}