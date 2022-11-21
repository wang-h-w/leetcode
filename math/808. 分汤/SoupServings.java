import java.util.Map;
import java.util.HashMap;

class SoupServings {
	private static Map<Integer, int[]> map = new HashMap<>();
	private Map<String, Double> memo; // 用来记忆化搜索

	public double soupServings(int n) {
		if (n > 5000) return 1; // 经验
		for (int i = 0; i < 4; i++) map.put(i, new int[] {100 - i * 25, i * 25});
		memo = new HashMap<>();
		return serve(n, n);
	}

	private double serve(int a, int b) {
		if (a <= 0 && b <= 0) return 0.5;
		else if (a <= 0) return 1;
		else if (b <= 0) return 0;
		double res = 0;
		for (int i = 0; i < 4; i++) {
			int[] provide = map.get(i);
			int aa = provide[0], bb = provide[1];
			String key = (a - aa) + " " + (b - bb);
			if (a > aa && b > bb) {
				if (!memo.containsKey(key)) memo.put(key, serve(a - aa, b - bb));
				res += memo.get(key);
			} else res += serve(a - aa, b - bb);
		}
		return 0.25 * res;
	}

	public static void main(String[] args) {
		SoupServings soup = new SoupServings();
		System.out.println(soup.soupServings(50));
		System.out.println(soup.soupServings(100));
		System.out.println(soup.soupServings(5000));
	}
}