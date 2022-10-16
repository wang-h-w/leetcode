import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

class PossibleBipartition {
	private int[] p = new int[4010];

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    private boolean query(int a, int b) {
        return find(a) == find(b);
    }

    public boolean possibleBipartition(int n, int[][] ds) {
        for (int i = 1; i <= 2 * n; i++) p[i] = i;
        for (int[] info : ds) {
            int a = info[0], b = info[1];
            if (query(a, b)) return false;
            union(a, b + n);
            union(b, a + n);
        }
        return true;
    }

	public static void main(String[] args) {
		PossibleBipartition pb = new PossibleBipartition();
		System.out.println(pb.possibleBipartition(10, new int[][] {{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}}));
		System.out.println(pb.possibleBipartition(4, new int[][] {{1,2},{1,3},{2,4}}));
		System.out.println(pb.possibleBipartition(3, new int[][] {{1,2},{1,3},{2,3}}));
		System.out.println(pb.possibleBipartition(5, new int[][] {{1,2},{2,3},{3,4},{4,5},{1,5}}));
	}
}