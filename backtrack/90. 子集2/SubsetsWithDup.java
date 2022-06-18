import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class SubsetsWithDup {
	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		ret.add(new LinkedList<>());
		Arrays.sort(nums);
		backtrack(nums, 0);
		return ret;
	}

	private void backtrack(int[] nums, int start) {
		if (path.size() == nums.length) return;
		for (int i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i-1]) continue;
			path.add(nums[i]);
			ret.add(new LinkedList<>(path));
			backtrack(nums, i + 1);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		SubsetsWithDup s = new SubsetsWithDup();
		int[] nums = new int[] {1,2,2};
		System.out.println(s.subsetsWithDup(nums));
	}
}