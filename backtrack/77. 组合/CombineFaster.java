import java.util.List;
import java.util.LinkedList;

class CombineFaster {
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
		// 注意剪枝的优化问题！可以节省时间！
		// 这里，k长度，所以倒数k-1个都不可能是第一个数字
		for (int i = start; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			backtrack(i+1, n, k);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
	 	CombineFaster c = new CombineFaster();
	 	System.out.println(c.combine(4,3));
	} 
}