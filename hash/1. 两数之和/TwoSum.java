import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(target - nums[i])) {
				return new int[]{hm.get(target - nums[i]), i};
			}
			hm.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] nums = new int[]{2, 7, 11, 15};
		int[] result = ts.twoSum(nums, 26);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}