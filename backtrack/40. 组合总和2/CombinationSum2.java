import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class CombinationSum2 {
	List<List<Integer>> ret = new ArrayList<>();
	ArrayList<Integer> path = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		backtrace(candidates, target, 0);
		return ret;
	}

	private void backtrace(int[] candidates, int target, int idx) {
		if (target == 0) {
			ret.add(new ArrayList<>(path));
			return;
		}
		for (int i = idx; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				if (i > idx && candidates[i] == candidates[i-1]) continue;
				path.add(candidates[i]);
				backtrace(candidates, target - candidates[i], i + 1);
				path.remove(path.size() - 1);
			}
		}

	}

	public static void main(String[] args) {
		CombinationSum2 cs = new CombinationSum2();
		int[] candidates = new int[] {10,1,2,7,6,1,5};
		candidates = new int[] {2,5,2,1,2};
		List<List<Integer>> result = cs.combinationSum2(candidates, 5);
		System.out.println(result);
	}
}