import java.util.List;
import java.util.LinkedList;

class CombinationSum3 {
	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		backtrack(1, k, n);
		return ret;
	}

	private void backtrack(int start, int k, int n) {
		if (n < 0) return;
		if (k == 0 && n == 0){
			ret.add(new LinkedList<>(path));
			return;
		}
		for (int i = start; i <= 9; i++) {
			path.add(i);
			backtrack(i + 1, k - 1, n - i);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		CombinationSum3 sum = new CombinationSum3();
		// System.out.println(sum.combinationSum3(3, 7));
		// System.out.println(sum.combinationSum3(3, 9));
		// System.out.println(sum.combinationSum3(4, 1));
		System.out.println(sum.combinationSum3(9, 45));
	}
}