import java.util.Set;
import java.util.HashSet;

class GetKthMagicNumber {
	public int getKthMagicNumber(int k) {
		if (k <= 0) return 0;
		int[] idx = new int[3];
		int[] list = new int[k];
		Set<Integer> set = new HashSet<>();
		int next = 1;
		list[0] = 1;;
		set.add(1);

		while (next < k) {
			int a = 3 * list[idx[0]], b = 5 * list[idx[1]], c = 7 * list[idx[2]];
			int min = Math.min(a, Math.min(b, c));
			if (!set.contains(min)) {
				list[next++] = min;
				set.add(min);
			}
			if (a == min) idx[0]++;
			if (b == min) idx[1]++;
			if (c == min) idx[2]++;
		}

		return list[k-1];
	}

	public static void main(String[] args) {
		GetKthMagicNumber k = new GetKthMagicNumber();
		for (int i = 1; i <= 10; i++) System.out.println(k.getKthMagicNumber(i));
	}
}