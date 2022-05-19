import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ret = new LinkedList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int front = j + 1;
				int end = nums.length - 1;
				while (front < end) {
					int sum = nums[i] + nums[j] + nums[front] + nums[end];
					if (sum == target) {
						List<Integer> l = new LinkedList<>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[front]);
						l.add(nums[end]);
						ret.add(l);
						while (front < end && nums[front + 1] == nums[front]) front++;
						while (front < end && nums[end - 1] == nums[end]) end--;
						front++;
						end--;
					} else if (sum < target) {
						front++;
					} else {
						end--;
					}
				}
				while (j < nums.length - 2 && nums[j + 1] == nums[j]) j++;
			}
			while (i < nums.length - 3 && nums[i + 1] == nums[i]) i++;
		}

		return ret;
	}

	public static void main(String[] args) {
		FourSum f = new FourSum();
		int[] nums = new int[] {1, 0, -1, 0, -2, 2};
		// nums = new int[] {2, 2, 2, 2, 2};
		// nums = new int[] {0, 0, 0, 0, 0, 1, -1};
		// nums = new int[] {0, 0, 2};
		List<List<Integer>> result = f.fourSum(nums, 0);
		System.out.println(result);
	}
}