import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class GenerateParenthesis {
	List<String> ret = new LinkedList<>();

	public List<String> generateParenthesis(int n) {
		backtrack(n, "", 0, 0);
		return ret;
	}

	private void backtrack(int n, String track, int left, int right) {
		if (left == n && right == n) {
			ret.add(track);
			return;
		}
		if (left > n || right > n || left < right) return;
		backtrack(n, track + "(", left + 1, right);  // DFS
		backtrack(n, track + ")", left, right + 1);
	}

	public static void main(String[] args) {
		GenerateParenthesis gen = new GenerateParenthesis();
		List<String> result = gen.generateParenthesis(3);
		System.out.println(result);
	}
}