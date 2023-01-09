import java.util.Arrays;

class ReinitializePermutation {
	public int reinitializePermutation(int n) {
		int res = 0;
		int[] perm = new int[n];
		for (int i = 0; i < n; i++) perm[i] = i;
		while (res == 0 || !check(perm)) {
			int[] temp = new int[n];
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) temp[i] = perm[i / 2];
				else temp[i] = perm[n / 2 + (i - 1) / 2];
			}
			perm = temp;
			res++;
		}
		return res;
	}

	private boolean check(int[] perm) {
		for (int i = 0; i < perm.length; i++) {
			if (perm[i] != i) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ReinitializePermutation rp = new ReinitializePermutation();
		System.out.println(rp.reinitializePermutation(2));
		System.out.println(rp.reinitializePermutation(4));
		System.out.println(rp.reinitializePermutation(6));
	}
}