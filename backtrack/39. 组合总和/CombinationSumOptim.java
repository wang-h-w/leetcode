import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class CombinationSumOptim {
	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> track = new LinkedList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		backtrack(candidates, target, 0);
		return ret;
	}

	private void backtrack(int[] candidates, int target, int idx) {
		if (target < 0) return;
		if (target == 0) {
			ret.add(new LinkedList<>(track));
			return;
		}
		for (int i = idx; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				track.add(candidates[i]);
				backtrack(candidates, target - candidates[i], i);
				track.removeLast();
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumOptim cs = new CombinationSumOptim();
		int[] candidates = new int[] {2, 3, 5};
		List<List<Integer>> result = cs.combinationSum(candidates, 8);
		System.out.println(result);
	}
}