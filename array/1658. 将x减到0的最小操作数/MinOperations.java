import java.util.Arrays;

class MinOperations {
	public int minOperations(int[] nums, int x) {
		int target = Arrays.stream(nums).sum() - x, n = nums.length;
		int left = 0, right = 0, curr = 0, min = Integer.MAX_VALUE;
		while (right < n) {
			curr += nums[right++];
			while (curr > target && left < right) curr -= nums[left++];
			if (curr == target) min = Math.min(min, n - (right - left));
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public static void main(String[] args) {
		MinOperations mo = new MinOperations();
		System.out.println(mo.minOperations(new int[] {1,1,4,2,3}, 5));
		System.out.println(mo.minOperations(new int[] {5,6,7,8,9}, 4));
		System.out.println(mo.minOperations(new int[] {3,2,20,1,1,3}, 10));
	}
}