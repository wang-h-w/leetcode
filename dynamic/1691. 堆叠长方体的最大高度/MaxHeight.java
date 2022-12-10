import java.util.Arrays;

class MaxHeight {
	public int maxHeight(int[][] cuboids) {
		for (int[] c : cuboids) Arrays.sort(c);
        Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int ans = 0, n = cuboids.length;
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j)
                // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2])
                    f[i] = Math.max(f[i], f[j]); // cuboids[j] 可以堆在 cuboids[i] 上
            f[i] += cuboids[i][2];
            ans = Math.max(ans, f[i]);
        }
        return ans;
	}

	public static void main(String[] args) {
		MaxHeight mh = new MaxHeight();
		System.out.println(mh.maxHeight(new int[][] {{50,45,20},{95,37,53},{45,23,12}}));
		System.out.println(mh.maxHeight(new int[][] {{38,25,45},{76,35,3}}));
		System.out.println(mh.maxHeight(new int[][] {{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}}));
	}
}