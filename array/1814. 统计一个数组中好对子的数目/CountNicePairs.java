import java.util.Map;
import java.util.HashMap;

class CountNicePairs {
	public int countNicePairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		long res = 0, MOD = 1000000007;
		for (int i = 0; i < nums.length; i++) {
			StringBuffer sb = new StringBuffer(String.valueOf(nums[i]));
			int rev = Integer.parseInt(sb.reverse().toString());
			nums[i] -= rev;
			if (!map.containsKey(nums[i])) map.put(nums[i], 0);
			map.put(nums[i], map.get(nums[i]) + 1);
		}
		for (int k : map.keySet()) {
			int value = map.get(k);
			if (value <= 1) continue;
			res += 1L * value * (value - 1) / 2;
			res %= MOD;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		CountNicePairs cnp = new CountNicePairs();
		System.out.println(cnp.countNicePairs(new int[] {42,11,1,97}));
		System.out.println(cnp.countNicePairs(new int[] {13,10,35,24,76}));
	}
}