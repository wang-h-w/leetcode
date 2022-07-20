import java.util.Random;

class FindKthLargest {
	private final static Random r = new Random();

	public int findKthLargest(int[] nums, int k) {
		// int start = 0, end = nums.length - 1;
		// while (true) {
		// 	int index = partition(nums, start, end);
		// 	if (index == nums.length - k) return nums[index];
		// 	else if (index < nums.length - k) start = index + 1;
		// 	else end = index - 1;
		// }
		quickSort(nums, 0, nums.length - 1);
		return nums[nums.length - k];
	}

	private void quickSort(int[] nums, int start, int end) {
		if (start >= end) return;
		int index = partition(nums, start, end);
		quickSort(nums, start, index - 1);
		quickSort(nums, index + 1, end);
	}

	private int partition(int[] nums, int start, int end) {
		// random
		int pivotIndex = r.nextInt(end - start + 1) + start, pivot = nums[pivotIndex];
		swap(nums, pivotIndex, start);
		// sort
		int left = start + 1, right = end;
		while (left < right) {
			while (left < right && nums[left] <= pivot) left++;
			while (left < right && nums[right] >= pivot) right--;
			swap(nums, left, right);
		}
		if (left == right && pivot < nums[right]) right--; // 这句很重要！！！
		swap(nums, start, right);
		return right;
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}

	public static void main(String[] args) {
		FindKthLargest find = new FindKthLargest();
		int[] nums = new int[] {3,2,1,5,6,4};
		System.out.println(find.findKthLargest(nums, 2));
		for (int i : nums) System.out.print(i + " ");
		System.out.println();
		nums = new int[] {3,2,3,1,2,4,5,5,6};
		System.out.println(find.findKthLargest(nums, 4));
		for (int i : nums) System.out.print(i + " ");
		System.out.println();
	}
}