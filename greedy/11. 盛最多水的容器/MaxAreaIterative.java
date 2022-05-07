class MaxAreaIterative {
	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			max = height[start] < height[end] ? 
			Math.max(max, (end - start) * height[start++]) : 
			Math.max(max, (end - start) * height[end--]);
		}

		return max;
	}

	public static void main(String[] args) {
		MaxAreaIterative ma = new MaxAreaIterative();
		int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
		// height = new int[] {9, 5, 3, 8, 9, 3, 5, 2};
		int area = ma.maxArea(height);
		System.out.println(area);
	}
}