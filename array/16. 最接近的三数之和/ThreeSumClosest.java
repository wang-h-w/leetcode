import java.util.Arrays;

class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int bestDist = Integer.MAX_VALUE;
		int bestSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int front = i + 1;
			int end = nums.length - 1;
			while (front < end) {
				int sum = curr + nums[front] + nums[end];
				int dist = sum - target;
				if (Math.abs(dist) < bestDist) {
					bestDist = Math.abs(dist);
					bestSum = dist + target;
				}
				if (dist == 0) {
					return target;
				} else if (dist < 0) {
					front++;
				} else {
					end--;
				}
			}
		}
		return bestSum;
	}

	public static void main(String[] args) {
		ThreeSumClosest ts = new ThreeSumClosest();
		int[] nums = new int[] {-1, 2, 1, -4};
		nums = new int[] {3,6,3,-2,-6,-3,-5,7};
		nums = new int[] {1,1,1,1};
		int result = ts.threeSumClosest(nums, 0);
		System.out.println(result);
	}
}