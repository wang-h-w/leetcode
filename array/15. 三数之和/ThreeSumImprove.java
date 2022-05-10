import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class ThreeSumImprove {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if (nums.length < 3) {
			return result;
		}
		
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) return result;
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int front = i + 1;
			int end = nums.length - 1;
			while (front < end) {
				int sum = nums[i] + nums[front] + nums[end];
				if (sum == 0) {
					List<Integer> l = new LinkedList<>();
					l.add(nums[front]);
					l.add(nums[i]);
					l.add(nums[end]);
					result.add(l);
					while (front < end && nums[front + 1] == nums[front]) front++;
					while (front < end && nums[end - 1] == nums[end]) end--;
					front++;
					end--;
				} else if (sum < 0) {
					front++; // because it has been sorted!
				} else {
					end--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ThreeSumImprove ts = new ThreeSumImprove();
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		// nums = new int[] {0,0,0,0,0};
		List<List<Integer>> result = ts.threeSum(nums);
		System.out.println(result);
	}
}