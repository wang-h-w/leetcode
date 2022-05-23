import java.util.Arrays;

class Search {
	public int search(int[] nums, int target) {
		int start = findStart(nums);
		Arrays.sort(nums);
		int result = start + Arrays.binarySearch(nums, target);
		if (result < start) return -1;
		return result = result > nums.length - 1 ? result - nums.length : result;
	}

	private int findStart(int[] nums) {
		if (nums.length == 1) return 0;
		if (nums.length == 2) {
			if (nums[0] < nums[1]) return 0;
			else return 1;
		}
		int center = (nums.length - 1) / 2;
		if (center > 0 && nums[center - 1] > nums[center]) return center;
		if (center < nums.length - 1 && nums[center + 1] < nums[center]) return center + 1;
		if (nums[0] < nums[center] && nums[nums.length-1] > nums[center]) {
			return 0;
		} else if (nums[0] >= nums[center]) {
			return findStart(Arrays.copyOfRange(nums, 0, center));
		} else {
			return center + 1 + findStart(Arrays.copyOfRange(nums, center + 1, nums.length));
		}
	}

	public static void main(String[] args) {
		Search s = new Search();
		int[] nums = new int[] {4,5,6,7,0,1,2};
		int result = s.search(nums, 3);
		System.out.println(result);
	}
}