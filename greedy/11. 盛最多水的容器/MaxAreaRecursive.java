class MaxAreaRecursive {
	public int maxArea(int[] height) {
		return findMax(height, 0, height.length - 1, 0);
	}

	private int findMax(int[] height, int start, int end, int max) {
		if (start == end) return max;
		int curr = (end - start) * Math.min(height[start], height[end]);
		max = max >= curr ? max : curr;
		if (height[start] < height[end]) {
			return findMax(height, ++start, end, max);
		} else {
			return findMax(height, start, --end, max);
		}
	}

	public static void main(String[] args) {
		MaxAreaRecursive ma = new MaxAreaRecursive();
		int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
		height = new int[] {9, 5, 3, 8, 9, 3, 5, 2};
		int area = ma.maxArea(height);
		System.out.println(area);
	}
}