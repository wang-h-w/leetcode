import java.util.Arrays;

class SumSubseqWidths {
	// 打表避免重复计算
	static int N = 100010, MOD = (int)1e9+7;
	static long[] p = new long[N];
	static {
		p[0] = 1;
		for (int i = 1; i < N; i++) p[i] = p[i - 1] * 2 % MOD;
	}

	// 计算贡献度！！！！
	public int sumSubseqWidths(int[] nums) {
		int n = nums.length;
		long ans = 0;
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			ans += (p[i] * nums[i]) % MOD;
			ans %= MOD;
			ans -= (p[n - i - 1] * nums[i]) % MOD;
			ans %= MOD;
		}
		return (int)ans;
	}

	public static void main(String[] args) {
		SumSubseqWidths ssw = new SumSubseqWidths();
		System.out.println(ssw.sumSubseqWidths(new int[] {2,1,3}));
		System.out.println(ssw.sumSubseqWidths(new int[] {2}));
		System.out.println(ssw.sumSubseqWidths(new int[] {2,1,3,4}));
	}
}