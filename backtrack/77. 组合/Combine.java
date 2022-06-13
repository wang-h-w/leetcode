import java.util.List;
import java.util.LinkedList;

class Combine {
	List<List<Integer>> ret = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> combine(int n, int k) {
		backtrack(1, n, k);
		return ret;
	}

	private void backtrack(int start, int n, int k) {
		if (path.size() == k) {
			ret.add(new LinkedList<>(path));
			return;
		}
		for (int i = start; i <= n; i++) {
			path.add(i);
			backtrack(i+1, n, k);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
	 	Combine c = new Combine();
	 	System.out.println(c.combine(4,3));
	} 
}