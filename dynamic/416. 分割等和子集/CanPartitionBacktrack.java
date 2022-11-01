import java.util.Arrays;

class CanPartition {
	public boolean canPartition(int[] nums) {
		if (nums.length < 2) return false;
		Arrays.sort(Arrays.stream(nums).boxed().toArray(Integer[]::new), (n1, n2) -> n2 - n1);
		int sum = 0;
		for (int i : nums) sum += i;
		if (sum % 2 != 0) return false;
		return dfs(nums, sum / 2, 0, 0);
	}

	private boolean dfs(int[] nums, int ideal, int start, int sum) {
		if (sum > ideal) return false;
		if (sum == ideal) return true;
		for (int i = start; i < nums.length; i++) {
			if (dfs(nums, ideal, i + 1, sum + nums[i])) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CanPartition cp = new CanPartition();
		System.out.println(cp.canPartition(new int[] {1,5,11,5}));
		System.out.println(cp.canPartition(new int[] {1,2,3,5}));
		System.out.println(cp.canPartition(new int[] {1,2,-1,2,1,1}));
	}
}