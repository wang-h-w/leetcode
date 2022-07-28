import java.util.List;
import java.util.ArrayList;

class DiffWaysToCompute {
	char[] cs;
	public List<Integer> diffWaysToCompute(String expression) {
		cs = expression.toCharArray();
		return dfs(0, cs.length - 1);
	}

	private List<Integer> dfs(int l, int r) {
		List<Integer> ans = new ArrayList<>();
		for (int i = l; i <= r; i++) {
			if (cs[i] >= '0' && cs[i] <= '9') continue;
			List<Integer> l1 = dfs(l, i - 1), l2 = dfs(i + 1, r);
			for (int a : l1) {
				for (int b : l2) {
					int curr = 0;
					if (cs[i] == '+') curr = a + b;
					else if (cs[i] == '-') curr = a - b;
					else curr = a * b;
					ans.add(curr);
				}
			}
		}
		if (ans.isEmpty()) {
			int curr = 0;
			for (int i = l; i <= r; i++) curr = curr * 10 + (cs[i] - '0');
			ans.add(curr);
		}

		return ans;
	}

	public static void main(String[] args) {
		DiffWaysToCompute diff = new DiffWaysToCompute();
		System.out.println(diff.diffWaysToCompute("2-1-1"));
		System.out.println(diff.diffWaysToCompute("2*3-4*5"));
	}
}