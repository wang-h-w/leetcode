import java.util.Map;
import java.util.HashMap;

class ContainsNearbyDuplicate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(map.get(nums[i]) - i) <= k) return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsNearbyDuplicate c = new ContainsNearbyDuplicate();
		System.out.println(c.containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
		System.out.println(c.containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
		System.out.println(c.containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
	}
}