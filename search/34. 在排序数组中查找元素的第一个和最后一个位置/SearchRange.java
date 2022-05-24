import java.util.Arrays;

class SearchRange {
	public int[] searchRange(int[] nums, int target) {
		int[] ret = new int[] {-1, -1};
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			if (target < nums[start] || target > nums[end]) return ret;
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				int rangeStart = mid, rangeEnd = mid;
				while (rangeStart >= 0 && nums[rangeStart] == target) rangeStart--;
				while (rangeEnd < nums.length && nums[rangeEnd] == target) rangeEnd++;
				ret[0] = rangeStart + 1;
				ret[1] = rangeEnd - 1;
				return ret;
			} else if (nums[mid] < target && target <= nums[end]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		SearchRange s = new SearchRange();
		int[] nums = new int[] {5,7,7,7,8,8,10};
		int[] result = s.searchRange(nums, 8);
		for (int i: result) System.out.println(i);
	}
}