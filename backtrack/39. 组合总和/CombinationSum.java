import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class CombinationSum {
	List<List<Integer>> ret = new LinkedList<>();
	int target;
	int[] candidates;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		LinkedList<Integer> track = new LinkedList<>();
		Arrays.sort(candidates);
		this.candidates = candidates;
		this.target = target;
		backtrack(track, 0);
		return ret;
	}

	private void backtrack(LinkedList<Integer> track, int sum) {
		if (sum > target) return;
		if (sum == target) {
			ret.add(new LinkedList<>(track));
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			if (!track.isEmpty() && candidates[i] < track.getLast()) continue;
			track.add(candidates[i]);
			backtrack(track, sum + candidates[i]);
			track.removeLast();
		}
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = new int[] {2, 3, 5};
		List<List<Integer>> result = cs.combinationSum(candidates, 8);
		System.out.println(result);
	}
}