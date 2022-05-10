import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if (nums.length < 3) {
			return result;
		}
		
		Arrays.sort(nums);
		int front = 0;
		int end = nums.length - 1;

		while (nums[front] <= 0 && end > front) {
			if (front != 0 && nums[front] == nums[front - 1]) {
				front += 1;
				continue;
			}
			while (nums[end] >= 0 && end > front) {
				if (end != (nums.length - 1) && nums[end] == nums[end + 1]) {
					end -= 1;
					continue;
				}
				int want = -(nums[front] + nums[end]);
				for (int i = front + 1; i <= end - 1; i++) {
					if (nums[i] == want) {
						List<Integer> l = new LinkedList<>();
						l.add(nums[front]);
						l.add(nums[i]);
						l.add(nums[end]);
						result.add(l);
						break;
					}
				}
				end -= 1;
			}
			front += 1;
			end = nums.length - 1;
		}

		return result;
	}

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		// nums = new int[] {0,0,0,0};
		List<List<Integer>> result = ts.threeSum(nums);
		System.out.println(result);
	}
}