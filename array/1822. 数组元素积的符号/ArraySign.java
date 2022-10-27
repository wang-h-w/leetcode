class ArraySign {
	public int arraySign(int[] nums) {
		int neg = 0;
		for (int i : nums) {
			if (i == 0) return 0;
			else if (i < 0) neg++;
		}
		return neg % 2 == 0 ? 1 : -1;
	}

	public static void main(String[] args) {
		ArraySign as = new ArraySign();
		System.out.println(as.arraySign(new int[] {-1,-2,-3,-4,3,2,1}));
		System.out.println(as.arraySign(new int[] {1,5,0,2,-3}));
		System.out.println(as.arraySign(new int[] {-1,1,-1,1,-1}));
		System.out.println(as.arraySign(new int[] {2,3}));
	}
}