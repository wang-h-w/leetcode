class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int front = 0, end = numbers.length - 1;
		while (front < end) {
			int sum = numbers[front] + numbers[end];
			if (sum == target) return new int[] {front + 1, end + 1};
			else if (sum < target) front++;
			else end--;
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum sum = new TwoSum();
		int[] numbers = new int[] {2,7,11,15};
		numbers = new int[] {-1, 0};
		int[] result = sum.twoSum(numbers, -1);
		for (int i: result) System.out.print(i + " ");
	}
}