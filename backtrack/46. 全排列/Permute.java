import java.util.List;
import java.util.LinkedList;

class Permute {
	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> permute(int[] nums) {
		backtrack(nums);
		return ret;
	}

	private void backtrack(int[] nums) {
		if (path.size() == nums.length) {
			ret.add(new LinkedList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (path.contains(nums[i])) continue;
			path.add(nums[i]);
			backtrack(nums);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		Permute p = new Permute();
		int[] nums = new int[] {1,2,3};
		List<List<Integer>> result = p.permute(nums);
		System.out.println(result);
	}
}