import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class PermuteUnique {
	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();
	boolean[] inPath;

	public List<List<Integer>> permuteUnique(int[] nums) {
		this.inPath = new boolean[nums.length];
		for (int i = 0; i < inPath.length; i++) inPath[i] = false;
		Arrays.sort(nums);
		backtrack(nums);
		return ret;
	}

	private void backtrack(int[] nums) {
		if (path.size() == nums.length) {
			ret.add(new LinkedList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i-1] && inPath[i-1] == false) continue;
			if (!inPath[i]) {
				path.add(nums[i]);
				inPath[i] = true;
				backtrack(nums);
				path.removeLast();
				inPath[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		PermuteUnique p = new PermuteUnique();
		int[] nums = new int[] {1,1,1,2,2};
		List<List<Integer>> result = p.permuteUnique(nums);
		System.out.println(result);
	}
}