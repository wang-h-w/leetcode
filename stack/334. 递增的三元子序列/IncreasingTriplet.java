class IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
		int smallestValue = Integer.MAX_VALUE, smallestDup = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= smallestValue) smallestValue = n;
			else smallestDup = Math.min(smallestDup, n);
			if (n > smallestDup) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		IncreasingTriplet it = new IncreasingTriplet();
		System.out.println(it.increasingTriplet(new int[] {1,2,3,4,5}));
		System.out.println(it.increasingTriplet(new int[] {5,4,3,2,1}));
		System.out.println(it.increasingTriplet(new int[] {2,1,5,0,4,6}));
		System.out.println(it.increasingTriplet(new int[] {2,1,5,0,6,4}));
		System.out.println(it.increasingTriplet(new int[] {2,1,5,0,4,5}));
	}
}