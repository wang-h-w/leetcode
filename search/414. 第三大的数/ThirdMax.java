class ThirdMax {
	long INF = (long)-1e18;

	public int thirdMax(int[] nums) {
        long a = INF, b = INF, c = INF;
        for (int x : nums) {
            if (x > a) {
                c = b;
                b = a;
                a = x;
            } else if (x < a && x > b) {
                c = b;
                b = x;
            } else if (x < b && x > c) {
                c = x;
            }
        }
        return c != INF ? (int)c : (int)a;
	}

	public static void main(String[] args) {
		ThirdMax tm = new ThirdMax();
		System.out.println(tm.thirdMax(new int[] {3,2,1}));
		System.out.println(tm.thirdMax(new int[] {1,2,-2147483648}));
		System.out.println(tm.thirdMax(new int[] {2,2,3,1}));
	}
}