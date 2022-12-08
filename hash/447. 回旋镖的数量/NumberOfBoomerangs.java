import java.util.Map;
import java.util.HashMap;

class NumberOfBoomerangs {
	public int numberOfBommerangs(int[][] points) {
		int n = points.length, res = 0;
		for (int i = 0; i < n; i++) {
			Map<Integer, Integer> map = new HashMap<>(); // map: dist -> start
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
				int dist = x * x + y * y;
				map.put(dist, map.getOrDefault(dist, 0) + 1);
			}
			for (int dist : map.keySet()) {
				int cnt = map.get(dist);
				res += cnt * (cnt - 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NumberOfBoomerangs nb = new NumberOfBoomerangs();
		System.out.println(nb.numberOfBommerangs(new int[][] {{0,0},{1,0},{2,0}}));
		System.out.println(nb.numberOfBommerangs(new int[][] {{1,1},{2,2},{3,3}}));
		System.out.println(nb.numberOfBommerangs(new int[][] {{1,1}}));
	}
}