import java.util.Arrays;

class CombinationSum4 {
	public int combinationSum4(int[] nums, int t) {
		int[] f = new int[t + 1];
        f[0] = 1;
        for (int j = 1; j <= t; j++) {
            for (int u : nums) {
                if (j >= u) f[j] += f[j - u];
            }
        }
        return f[t];
	}

	public static void main(String[] args) {
		CombinationSum4 sum = new CombinationSum4();
		System.out.println(sum.combinationSum4(new int[] {1,2,3}, 4));
		System.out.println(sum.combinationSum4(new int[] {3}, 4));
	}
}