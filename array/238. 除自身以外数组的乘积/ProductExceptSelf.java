class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		res[n-1] = 1;
		// first: from left to right
		int product = 1;
		for (int i = 1; i < n; i++) {
			product *= nums[i-1];
			res[i] = product;
		}
		// second: from right to left (and sum together)
		product = 1;
		for (int i = n - 2; i >= 0; i--) {
			product *= nums[i+1];
			res[i] *= product;
		}

		return res;
	}

	public static void main(String[] args) {
		ProductExceptSelf p = new ProductExceptSelf();
		int[] res = p.productExceptSelf(new int[] {2,4,3});
		for (int i: res) System.out.print(i + " ");
		System.out.println();
		res = p.productExceptSelf(new int[] {-1,1,0,-3,3});
		for (int i: res) System.out.print(i + " ");
		System.out.println();
	}
}