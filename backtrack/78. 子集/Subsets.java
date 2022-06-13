import java.util.List;
import java.util.LinkedList;

class Subsets {
	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums, 0);
		ret.add(new LinkedList<>());
		return ret;
	}

	private void backtrack(int[] nums, int start) {
		if (start >= nums.length) return;
		for (int i = start; i < nums.length; i++) {
			path.add(nums[i]);
			ret.add(new LinkedList<>(path));
			backtrack(nums, i + 1);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = new int[] {2,3,1};
		// nums = new int[] {0};
		System.out.println(s.subsets(nums));
	}
}