import java.util.HashSet;

class SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) set.remove(nums[i]);
			else {
				set.add(nums[i]);
				result ^= nums[i];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		SingleNumber single = new SingleNumber();
		int[] nums = new int[] {0,1,0,1,0,1,99};
		nums = new int[] {2,2,3,2};
		System.out.println(single.singleNumber(nums));
	}
}